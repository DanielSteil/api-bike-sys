package br.com.lvds.BikeSys.domain.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.lvds.BikeSys.domain.model.Bike;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor @AllArgsConstructor 
@Builder(toBuilder = true)
public class ServiceDTO implements Serializable {

    private BigInteger id;

    private String description;

    private Double value;
    
    private Bike bike;

    private LocalDate serviceDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // FILTER FIELDS

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigInteger clientId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String clientName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String startDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String endDate;

}
