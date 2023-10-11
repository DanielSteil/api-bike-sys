package br.com.lvds.BikeSys.repository.service;

import java.util.List;

import br.com.lvds.BikeSys.domain.dto.ServiceDTO;
import br.com.lvds.BikeSys.domain.mapper.ServiceMapper;
import br.com.lvds.BikeSys.domain.model.Bike;
import br.com.lvds.BikeSys.domain.model.Client;
import br.com.lvds.BikeSys.domain.model.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class ServiceRepositoryImpl implements ServiceRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<ServiceDTO> buscaUltimosServicos(Long limitSize) {
        StringBuilder sql = new StringBuilder();
        sql.append("""
            SELECT s.*
            FROM services s
            ORDER BY s.service_date DESC
            LIMIT """).append(" "+limitSize);
        Query query = em.createNativeQuery(sql.toString(), Service.class);
        List<ServiceDTO> lastServices = ServiceMapper.fromEntities(query.getResultList());
        for(ServiceDTO service : lastServices) {
            String sqlBike = "SELECT b.* FROM bikes b WHERE b.id ="+service.getBikeId();
            Bike bike = (Bike) em.createNativeQuery(sqlBike, Bike.class).getSingleResult();
            String sqlClient = "SELECT c.* FROM clients c WHERE c.id ="+bike.getClientId();
            Client client = (Client) em.createNativeQuery(sqlClient, Client.class).getSingleResult();
            service.setClientName(client.getName());
            service.setClientBike(bike.getModel());
        }
        return lastServices;
    }
    
}
