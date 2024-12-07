package br.com.lvds.BikeSys.repository.client;

import br.com.lvds.BikeSys.domain.model.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import br.com.lvds.BikeSys.domain.criteria.PageCriteria;
import br.com.lvds.BikeSys.domain.dto.ClientDTO;
import br.com.lvds.BikeSys.domain.mapper.ClientMapper;

public class ClientRepositoryImpl implements ClientRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public Page<ClientDTO> getClients(ClientDTO filter, PageCriteria criteria) {
        StringBuilder sql = new StringBuilder();
        sql.append("""
                SELECT c.*
                FROM clients c
                WHERE c.active = true
                """);
        if(filter.getName() != null && !filter.getName().equals(""))
            sql.append("AND c.name ILIKE :clientName ");

        Query queryCount = em.createNativeQuery(sql.toString().replace("SELECT c.*", "SELECT COUNT(c.id)"));
        sql.append("ORDER BY c.name ASC");
        Query query = em.createNativeQuery(sql.toString(), Client.class);
        if(filter.getName() != null && !filter.getName().equals("")) {
            query.setParameter("clientName", "%" + filter.getName() + "%");
            queryCount.setParameter("clientName", "%" + filter.getName() + "%");
        }

        Long totalElements = Long.valueOf(queryCount.getFirstResult());
        query.setMaxResults(criteria.getPageSize());
        query.setFirstResult(criteria.getPageIndex() * criteria.getPageSize());
        return new PageImpl<>(ClientMapper.fromEntities(query.getResultList()), PageCriteria.getPageRequest(criteria), totalElements);
    }
    
}
