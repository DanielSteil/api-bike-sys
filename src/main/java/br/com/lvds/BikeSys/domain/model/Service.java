package br.com.lvds.BikeSys.domain.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "services")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder(toBuilder = true)
public class Service implements Serializable {

    private BigInteger id;

    private String description;

    private Double value;

    private LocalDateTime serviceDate;

}
