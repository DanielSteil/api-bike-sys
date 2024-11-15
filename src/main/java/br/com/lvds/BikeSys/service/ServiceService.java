package br.com.lvds.BikeSys.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lvds.BikeSys.domain.dto.ServicesDashboardsDTO;
import br.com.lvds.BikeSys.domain.dto.ServiceDTO;
import br.com.lvds.BikeSys.domain.dto.ServiceFullDTO;
import br.com.lvds.BikeSys.domain.mapper.ServiceMapper;
import br.com.lvds.BikeSys.repository.service.ServiceRepository;

@Service
public class ServiceService {
    
    @Autowired
    private ServiceRepository serviceRepository;

    public ServiceDTO createService(ServiceDTO service) throws Exception {
        return ServiceMapper.fromEntity(serviceRepository.save(ServiceMapper.fromDTO(service)));
    }

    public List<ServiceFullDTO> getLastServices(Long limitSize) throws Exception {
        return serviceRepository.buscaUltimosServicos(limitSize);
    }

    public ServicesDashboardsDTO getServicesCardsInfo() throws Exception {
        return ServicesDashboardsDTO.builder()
                .servicesWeek(serviceRepository.countServices(LocalDate.now().minusDays(7), LocalDate.now().plusDays(1)))
                .servicesMonth(serviceRepository.countServices(LocalDate.now().minusMonths(1), LocalDate.now().plusDays(1)))
                .totalAmountMonth(serviceRepository.calculateTotalAmountFromDate(LocalDate.now().minusMonths(1)))
            .build();
    }   

}
