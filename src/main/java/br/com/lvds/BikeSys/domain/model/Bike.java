package br.com.lvds.BikeSys.domain.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "bikes")
@Data
@NoArgsConstructor @AllArgsConstructor 
@Builder(toBuilder = true)
public class Bike implements Serializable {

    private BigInteger id;

    private String model;

    private LocalDateTime lastService;

    private List<Service> service;

}
