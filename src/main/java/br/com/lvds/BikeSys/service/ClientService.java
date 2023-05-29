package br.com.lvds.BikeSys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lvds.BikeSys.domain.dto.ClientDTO;
import br.com.lvds.BikeSys.domain.mapper.ClientMapper;
import br.com.lvds.BikeSys.domain.model.Client;
import br.com.lvds.BikeSys.repository.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    ClientRepository clientRepository;

    private ClientDTO saveClient(Client client) throws Exception {
        return ClientMapper.fromEntity(clientRepository.save(client));
    }

}
