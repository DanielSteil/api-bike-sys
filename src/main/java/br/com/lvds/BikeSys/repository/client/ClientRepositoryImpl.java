package br.com.lvds.BikeSys.repository.client;

import br.com.lvds.BikeSys.domain.model.Bike;
import br.com.lvds.BikeSys.domain.model.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.math.BigInteger;
import java.util.List;

import br.com.lvds.BikeSys.domain.criteria.PageCriteria;
import br.com.lvds.BikeSys.domain.dto.ClientDTO;
import br.com.lvds.BikeSys.domain.mapper.ClientMapper;

public class ClientRepositoryImpl implements ClientRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<ClientDTO> getClients(ClientDTO filter, PageCriteria criteria) {
        StringBuilder sql = new StringBuilder();
        sql.append("""
                SELECT c.*
                FROM clients c
                WHERE c.active = true
                """);
        if(filter.getName() != null && !filter.getName().equals(""))
            sql.append("AND c.name LIKE :clientName ");

        Query query = em.createNativeQuery(sql.toString(), Client.class);

        if(filter.getName() != null && !filter.getName().equals("")) {
            query.setParameter("clientName", "'%" + filter.getName() + "%'");
        }
        List<ClientDTO> clients = ClientMapper.fromEntities(query.getResultList());
        for(ClientDTO client : clients) {
            StringBuilder clientBikeSb = new StringBuilder();
            for(BigInteger bikeId : client.getBikesId()) {
                String sqlBike = "SELECT b.* FROM bikes b WHERE b.id ="+bikeId;
                Bike bike = (Bike) em.createNativeQuery(sqlBike, Bike.class).getSingleResult();
                clientBikeSb.append(bike.getModel()+",");
            }
            String clientBike = clientBikeSb.toString();
            if(clientBike.contains(","))
                clientBike.substring(0, clientBike.length()-2);
            System.out.println(clientBike);
            client.setBikes(clientBike);
        }
        return clients;
    }
    
}
