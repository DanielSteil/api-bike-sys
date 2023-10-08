package br.com.lvds.BikeSys.domain.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.lvds.BikeSys.domain.model.Bike;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor @AllArgsConstructor
@Builder(toBuilder = true)
public class ClientDTO implements Serializable {
    
    private BigInteger id;

    private String name;

    private String number;

    private List<BigInteger> bikesId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean active;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String bikes;

}
