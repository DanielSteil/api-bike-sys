package br.com.lvds.BikeSys.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.lvds.BikeSys.domain.criteria.PageCriteria;
import br.com.lvds.BikeSys.domain.dto.ClientDTO;
import br.com.lvds.BikeSys.domain.dto.ClientDashboardsDTO;
import br.com.lvds.BikeSys.domain.mapper.ClientMapper;
import br.com.lvds.BikeSys.domain.model.Bike;
import br.com.lvds.BikeSys.domain.model.Client;
import br.com.lvds.BikeSys.repository.BikeRepository;
import br.com.lvds.BikeSys.repository.client.ClientRepository;
import br.com.lvds.BikeSys.repository.service.ServiceRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private ServiceRepository serviceRepository;

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

    public ClientDashboardsDTO getClientDashboardsInfos() throws Exception {
        return ClientDashboardsDTO.builder()
                .totalClients(clientRepository.getTotalClients())
                .totalBikes(bikeRepository.getTotalBikes())
            .build();
    }

    public ClientDTO getClientById(BigInteger clientId) {
        ClientDTO client = ClientMapper.fromEntity(clientRepository.findById(clientId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found!")));
        client.setBikes(bikeRepository.getBikesByClientId(clientId));
        client.setTotalServices(serviceRepository.getCountByClientId(clientId));
        return client;
    }

    public ClientDTO patchClient(BigInteger clientId, ClientDTO clientDto) throws Exception {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found!"));
        return ClientMapper.fromEntity(clientRepository.save(clientDto.patch(client)));
    }

}
