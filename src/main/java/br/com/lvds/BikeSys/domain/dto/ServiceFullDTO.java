package br.com.lvds.BikeSys.domain.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder(toBuilder = true)
public class ServiceFullDTO implements Serializable {
    
    private BigInteger id;
 
    private String clientName;

    private String clientBike;

    private LocalDateTime serviceDate;

    private Double totalAmount;

}
