package br.com.lvds.BikeSys.repository.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import br.com.lvds.BikeSys.domain.criteria.PageCriteria;
import br.com.lvds.BikeSys.domain.dto.ServiceDTO;
import br.com.lvds.BikeSys.domain.mapper.ServiceMapper;
import br.com.lvds.BikeSys.domain.model.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query; 

public class ServiceRepositoryImpl implements ServiceRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<ServiceDTO> getLastServices(Long limitSize) {
        StringBuilder sql = new StringBuilder();
        sql.append("""
            SELECT s.*
            FROM services s
            ORDER BY s.id DESC
            LIMIT """).append(" "+limitSize);
        Query query = em.createNativeQuery(sql.toString(), Service.class);
        return ServiceMapper.fromEntities(query.getResultList());
    }

    @Override
    public Page<ServiceDTO> fetchServices(ServiceDTO filter, PageCriteria criteria) {
        StringBuilder sql = new StringBuilder();
        sql.append("""
                    SELECT s.* FROM services s 
                    INNER JOIN bikes b ON b.id = s.fk_bike_id 
                    INNER JOIN clients c ON c.id = b.fk_client_id
                    WHERE 1=1
                """);
        if(filter.getClientName() != null && !filter.getClientName().isEmpty()) {
            sql.append("AND c.name ILIKE :clientName ");
        }
        if(filter.getStartDate() != null && filter.getEndDate() != null) {
            sql.append("AND s.service_date >= :startDate ");
            sql.append("AND s.service_date <= :endDate ");
        }

        Query queryCount = em.createNativeQuery(sql.toString().replace("s.*", "COUNT(s.id)")); 
        sql.append("ORDER BY service_date DESC ");
        Query query = em.createNativeQuery(sql.toString(), Service.class); 

        if(filter.getClientName() != null && !filter.getClientName().isEmpty()) {
            query.setParameter("clientName", String.format("'%%s%'", filter.getClientName()));
            queryCount.setParameter("clientName", String.format("'%%s%'", filter.getClientName()));
        }
        if(filter.getStartDate() != null && filter.getEndDate() != null) {
            query.setParameter("startDate", filter.getStartDate());
            query.setParameter("endDate", filter.getEndDate());
            queryCount.setParameter("startDate", filter.getStartDate());
            queryCount.setParameter("endDate", filter.getEndDate());
        }  
        Long totalElements = Long.valueOf(queryCount.getFirstResult());
        query.setFirstResult(criteria.getPageIndex() * criteria.getPageSize());
        query.setMaxResults(criteria.getPageSize());
        return new PageImpl<>(ServiceMapper.fromEntities(query.getResultList()), PageCriteria.getPageRequest(criteria), totalElements);
    }
    
}
