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
@Table(name = "clients")
@Data
@NoArgsConstructor @AllArgsConstructor 
@Builder(toBuilder = true)
public class Client implements Serializable {

    private BigInteger id;

    private String name;

    private String number;

    private List<Bike> bikes;

    private LocalDateTime createdAt;

}
