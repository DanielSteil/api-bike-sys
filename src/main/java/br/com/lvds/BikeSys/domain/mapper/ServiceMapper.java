package br.com.lvds.BikeSys.domain.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.lvds.BikeSys.domain.dto.ServiceDTO;
import br.com.lvds.BikeSys.domain.model.Service;

public class ServiceMapper {
    
    public static Service fromDTO(ServiceDTO service) {
        return Service.builder()
                .id(service.getId())
                .description(service.getDescription())
                .value(service.getValue())
                .serviceDate(service.getServiceDate())
            .build();
    }

    public static ServiceDTO fromEntity(Service service) {
        return ServiceDTO.builder()
                .id(service.getId())
                .description(service.getDescription())
                .value(service.getValue())
                .serviceDate(service.getServiceDate())
            .build();
    }

    public static List<ServiceDTO> fromEntities(List<Service> services) {
        return services.stream().map((service) -> fromEntity(service)).collect(Collectors.toList());
    }

}
