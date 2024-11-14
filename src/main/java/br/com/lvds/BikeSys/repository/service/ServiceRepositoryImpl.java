package br.com.lvds.BikeSys.repository.service;

import java.util.List;

import br.com.lvds.BikeSys.domain.dto.ServiceFullDTO;
import br.com.lvds.BikeSys.domain.mapper.ServiceMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class ServiceRepositoryImpl implements ServiceRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<ServiceFullDTO> buscaUltimosServicos(Long limitSize) {
        StringBuilder sql = new StringBuilder();
        sql.append("""
            SELECT s.id, c.name, b.model, s.service_date, s.value
            FROM services s
            INNER JOIN bikes b ON b.id = s.fk_bike_id 
            INNER JOIN clients c ON c.id = b.fk_client_id 
            ORDER BY s.service_date DESC
            LIMIT """).append(" "+limitSize);
        Query query = em.createNativeQuery(sql.toString(), "servicesFull");
        List<ServiceFullDTO> lastServices = ServiceMapper.fromEntities(query.getResultList());
        return lastServices;
    }
    
}
