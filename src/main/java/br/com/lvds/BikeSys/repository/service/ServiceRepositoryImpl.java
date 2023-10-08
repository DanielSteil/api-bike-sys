package br.com.lvds.BikeSys.repository.service;

import java.util.List;

import br.com.lvds.BikeSys.domain.dto.LastServiceDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class ServiceRepositoryImpl implements ServiceRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<LastServiceDTO> buscaUltimosServicos() {
        StringBuilder sql = new StringBuilder();
        sql.append("""
            SELECT new br.com.lvds.BikeSys.domain.dto.LastServiceDTO(c."name", b.model, s.description, s.serviceDate)
            FROM Service s
            INNER JOIN Bike b ON b.id = s.fk_bike_id 
            INNER JOIN Client c ON b.id = ANY(c.bikesId)
            LIMIT 10
        """);
        Query query = em.createQuery(sql.toString(), LastServiceDTO.class);
        return query.getResultList();
    }
    
}
