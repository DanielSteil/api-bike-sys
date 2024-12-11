package br.com.lvds.BikeSys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.lvds.BikeSys.domain.criteria.PageCriteria;
import br.com.lvds.BikeSys.domain.dto.ClientDTO;
import br.com.lvds.BikeSys.domain.mapper.ClientMapper;
import br.com.lvds.BikeSys.domain.model.Bike;
import br.com.lvds.BikeSys.domain.model.Client;
import br.com.lvds.BikeSys.repository.BikeRepository;
import br.com.lvds.BikeSys.repository.client.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BikeRepository bikeRepository;

    public ClientDTO saveClient(ClientDTO clientDTO) throws Exception {
        ClientDTO client = ClientMapper.fromEntity(clientRepository.save(ClientMapper.fromDTO(clientDTO)));
        if(clientDTO.getBikeModel() != null && !clientDTO.getBikeModel().isEmpty()) {
            Bike bike = bikeRepository.save(Bike.builder()
                                    .client(ClientMapper.fromDTO(client))
                                    .model(clientDTO.getBikeModel()).build());
            List<Bike> clientBikes = new ArrayList<>();
            clientBikes.add(bike);
            client.setBikes(clientBikes);
        }
        return client;
    }

    public Page<ClientDTO> getClients(ClientDTO filter, PageCriteria criteria) throws Exception {
        return clientRepository.getClients(filter, criteria);
    }

}
