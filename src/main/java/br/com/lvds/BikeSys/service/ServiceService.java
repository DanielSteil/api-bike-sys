package br.com.lvds.BikeSys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lvds.BikeSys.domain.dto.LastServiceDTO;
import br.com.lvds.BikeSys.repository.service.ServiceRepository;

@Service
public class ServiceService {
    
    @Autowired
    private ServiceRepository serviceRepository;

    public List<LastServiceDTO> getLastServices() throws Exception {
        return serviceRepository.buscaUltimosServicos();
    }

}
