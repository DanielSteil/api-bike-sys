package br.com.lvds.BikeSys.repository.client;

import br.com.lvds.BikeSys.domain.model.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.springframework.data.domain.Page;

import br.com.lvds.BikeSys.domain.criteria.PageCriteria;
import br.com.lvds.BikeSys.domain.dto.ClientBikesDTO;
import br.com.lvds.BikeSys.domain.dto.ClientDTO;
import org.springframework.data.domain.PageImpl;


public class ClientRepositoryImpl implements ClientRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public Page<ClientDTO> getClients(ClientDTO filter, PageCriteria criteria) {
        StringBuilder sql = new StringBuilder();
        sql.append("""
                SELECT c.id as id,
                       c.name as name,
                       c.number as number,
                       b.model as bikes,
                       c.created_at as createdAt,
                       c.updated_at as updatedAt,
                       c.active as active
                FROM clients c
                INNER JOIN bikes b ON b.id = c.fk_bikes_id 
                WHERE c.active = true
                """);
        if(filter.getName() != null && !filter.getName().equals(""))
            sql.append("AND c.name ILIKE :clientName ");

        Query query = em.createNativeQuery(sql.toString(), ClientBikesDTO.class);
        Query queryCount = em.createNativeQuery(sql.toString().replace("SELECT *", "SELECT COUNT(*)"));

        if(filter.getName() != null && !filter.getName().equals("")) {
            query.setParameter("clientName", "'%" + filter.getName() + "%'");
            queryCount.setParameter("clientName", "'%" + filter.getName() + "%'");
        }
        long totalSize = (long) queryCount.getSingleResult();
        query.setMaxResults(criteria.getPageSize());
        query.setFirstResult(criteria.getPageIndex() * criteria.getPageSize());
        return new PageImpl<>(query.getResultList(), PageCriteria.getPageRequest(criteria), totalSize);
    }
    
}
