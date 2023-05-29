package br.com.lvds.BikeSys.domain.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.lvds.BikeSys.domain.dto.BikeDTO;
import br.com.lvds.BikeSys.domain.model.Bike;

public class BikeMapper {
    
    public static Bike fromDTO(BikeDTO bike) {
        return Bike.builder()
                .id(bike.getId())
                .model(bike.getModel())
                .service(bike.getService())
                .lastService(bike.getLastService())
            .build();
    }
    
    public static BikeDTO fromEntity(Bike bike) {
        return BikeDTO.builder()
                .id(bike.getId())
                .model(bike.getModel())
                .service(bike.getService())
                .lastService(bike.getLastService())
            .build();
    }

    public static List<BikeDTO> fromEntities(List<Bike> bikes) {
        return bikes.stream().map((bike) -> fromEntity(bike)).collect(Collectors.toList());
    }

}
