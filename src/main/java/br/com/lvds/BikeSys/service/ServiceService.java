package br.com.lvds.BikeSys.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lvds.BikeSys.domain.dto.ServicesDashboardsDTO;
import br.com.lvds.BikeSys.domain.dto.ServiceDTO;
import br.com.lvds.BikeSys.domain.mapper.ServiceMapper;
import br.com.lvds.BikeSys.repository.service.ServiceRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ServiceService {
    
    @Autowired
    private ServiceRepository serviceRepository;

    public ServiceDTO createService(ServiceDTO service) throws Exception {
        return ServiceMapper.fromEntity(serviceRepository.save(ServiceMapper.fromDTO(service)));
    }

    public ServiceDTO getServiceById(BigInteger id) {
        return ServiceMapper.fromEntity(serviceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Service not found!")));
    }   

    public List<ServiceDTO> getLastServices(Long limitSize) throws Exception {
        return serviceRepository.buscaUltimosServicos(limitSize);
    }

    public ServicesDashboardsDTO getServicesCardsInfo() throws Exception {
        return ServicesDashboardsDTO.builder()
                .servicesWeek(serviceRepository.countServices(LocalDate.now().minusDays(7), LocalDate.now().plusDays(1)))
                .servicesMonth(serviceRepository.countServices(LocalDate.now().minusMonths(1), LocalDate.now().plusDays(1)))
                .totalAmountMonth(serviceRepository.calculateTotalAmountFromDate(LocalDate.now().minusMonths(1)))
                .dateLastService(serviceRepository.getDateLastService())
            .build();
    }


}
