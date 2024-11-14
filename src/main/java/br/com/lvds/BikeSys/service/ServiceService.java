package br.com.lvds.BikeSys.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lvds.BikeSys.domain.dto.ServiceCountDTO;
import br.com.lvds.BikeSys.domain.dto.ServiceFullDTO;
import br.com.lvds.BikeSys.repository.service.ServiceRepository;

@Service
public class ServiceService {
    
    @Autowired
    private ServiceRepository serviceRepository;

    public List<ServiceFullDTO> getLastServices(Long limitSize) throws Exception {
        return serviceRepository.buscaUltimosServicos(limitSize);
    }

    public ServiceCountDTO countServices() {
        return ServiceCountDTO.builder()
                .servicesDay(serviceRepository.countServices(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1)))
                .servicesWeek(serviceRepository.countServices(LocalDate.now().minusDays(7), LocalDate.now().plusDays(1)))
                .servicesMonth(serviceRepository.countServices(LocalDate.now().minusMonths(1), LocalDate.now().plusDays(1)))
            .build();
    }   

}
