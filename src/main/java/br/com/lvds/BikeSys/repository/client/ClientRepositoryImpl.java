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
    public Page<ClientBikesDTO> getClients(ClientDTO filter, PageCriteria criteria) {
        StringBuilder sql = new StringBuilder();
        sql.append("""
                SELECT new br.com.lvds.BikeSys.domain.dto.ClientBikesDTO(c.id as id,
                       c.name as name,
                       c.number as number,
                       (SELECT json_agg(b) FROM Bike b WHERE b.clientId = c.id) as bikes,
                       c.createdAt as createdAt,
                       c.updatedAt as updatedAt,
                       c.active as active)
                FROM Cliet c
                WHERE c.active = true
                """);
        if(filter.getName() != null && !filter.getName().equals(""))
            sql.append("AND c.name LIKE :clientName ");

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
