package br.com.lvds.BikeSys.domain.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import br.com.lvds.BikeSys.domain.model.Service;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder(toBuilder = true)
public class BikeDTO implements Serializable {
    
    private BigInteger id;

    private String model;

    private LocalDateTime lastService;

    private List<Service> services;

}
