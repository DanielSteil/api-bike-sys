package br.com.lvds.BikeSys.domain.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor @AllArgsConstructor 
@Builder(toBuilder = true)
public class ServiceDTO implements Serializable {

    private BigInteger id;

    private String description;

    private Double value;

    private LocalDateTime serviceDate;

}
