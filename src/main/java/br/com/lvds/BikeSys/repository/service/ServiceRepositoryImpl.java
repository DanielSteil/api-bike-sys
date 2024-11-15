package br.com.lvds.BikeSys.repository.service;

import java.util.List;

import br.com.lvds.BikeSys.domain.dto.ServiceFullDTO;
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
            SELECT s.id AS id, c.name AS clientName, b.model AS clientBike, s.service_date AS serviceDate, s.value AS totalAmount
            FROM services s
            INNER JOIN bikes b ON b.id = s.fk_bike_id 
            INNER JOIN clients c ON c.id = b.fk_client_id 
            ORDER BY s.id DESC
            LIMIT """).append(" "+limitSize);
        Query query = em.createNativeQuery(sql.toString(), "servicesFull");
        return query.getResultList();
    }
    
}
