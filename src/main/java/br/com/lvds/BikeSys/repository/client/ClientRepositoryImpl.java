package br.com.lvds.BikeSys.repository.client;

import br.com.lvds.BikeSys.domain.model.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

import br.com.lvds.BikeSys.domain.dto.ClientDTO;
import br.com.lvds.BikeSys.domain.mapper.ClientMapper;

public class ClientRepositoryImpl implements ClientRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<ClientDTO> getClients(ClientDTO filter) {
        StringBuilder sql = new StringBuilder();
        sql.append("""
                SELECT c.*
                FROM clients c
                WHERE c.active = true
                """);
        if(filter.getName() != null && !filter.getName().equals(""))
            sql.append("AND c.name ILIKE :clientName ");

        Query query = em.createNativeQuery(sql.toString(), Client.class);
        if(filter.getName() != null && !filter.getName().equals("")) 
            query.setParameter("clientName", "%" + filter.getName() + "%");
        
        return ClientMapper.fromEntities(query.getResultList());
    }
    
}
