package br.com.lvds.BikeSys.repository.service;

import java.util.List;

import br.com.lvds.BikeSys.domain.dto.LastServiceDTO;
import br.com.lvds.BikeSys.domain.model.Service;
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
            SELECT s.*
            FROM services s
            LIMIT 10
        """);
        Query query = em.createNativeQuery(sql.toString(), Service.class);
        return query.getResultList();
    }
    
}
