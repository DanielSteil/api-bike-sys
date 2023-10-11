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
public class StockDTO implements Serializable {
    
    private BigInteger id;

    private String description;

    private Long amount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
