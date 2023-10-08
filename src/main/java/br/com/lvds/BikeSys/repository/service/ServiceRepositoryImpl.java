package br.com.lvds.BikeSys.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.lvds.BikeSys.domain.dto.LastServiceDTO;
import br.com.lvds.BikeSys.domain.dto.ServiceDTO;
import br.com.lvds.BikeSys.domain.mapper.ServiceMapper;
import br.com.lvds.BikeSys.domain.model.Bike;
import br.com.lvds.BikeSys.domain.model.Client;
import br.com.lvds.BikeSys.domain.model.Service;
import br.com.lvds.BikeSys.repository.BikeRepository;
import br.com.lvds.BikeSys.repository.client.ClientRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class ServiceRepositoryImpl implements ServiceRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Autowired
    private BikeRepository bikeRepository;

    private ClientRepository clientRepository;

    @Override
    public List<ServiceDTO> buscaUltimosServicos() {
        StringBuilder sql = new StringBuilder();
        sql.append("""
            SELECT s.*
            FROM services s
            LIMIT 10
        """);
        Query query = em.createNativeQuery(sql.toString(), Service.class);
        List<ServiceDTO> lastServices = ServiceMapper.fromEntities(query.getResultList());
        for(ServiceDTO service : lastServices) {
            String sqlBike = "SELECT b.* FROM bikes WHERE b.id ="+service.getBikeId();
            Bike bike = (Bike) em.createNativeQuery(sqlBike, Bike.class).getSingleResult();
            String sqlClient = "SELECT c.* FROM clients c WHERE c.id ="+bike.getClientId();
            Client client = (Client) em.createNativeQuery(sqlClient, Client.class).getSingleResult();
            service.setClientName(client.getName());
            service.setClientBike(bike.getModel());
        }
        return lastServices;
    }
    
}
