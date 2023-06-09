package br.com.lvds.BikeSys.repository.client;

import br.com.lvds.BikeSys.domain.model.Client;
import org.springframework.data.domain.Page;

import br.com.lvds.BikeSys.domain.criteria.PageCriteria;
import br.com.lvds.BikeSys.domain.dto.ClientDTO;
import org.springframework.data.domain.PageImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class ClientRepositoryImpl implements ClientRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public Page<ClientDTO> getClients(ClientDTO filter, PageCriteria criteria) {
        StringBuilder sql = new StringBuilder();
        sql.append("""
                SELECT *
                FROM clients c
                WHERE c.active = true
                """);
        if(filter.getName() != null && !filter.getName().equals(""))
            sql.append("AND c.name ILIKE :clientName ");

        Query query = em.createNativeQuery(sql.toString(), Client.class);
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
