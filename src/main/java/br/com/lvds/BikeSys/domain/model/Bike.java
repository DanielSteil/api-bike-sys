package br.com.lvds.BikeSys.domain.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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

    @Id
    @Column(nullable = false)
    @SequenceGenerator(name = "bike_sequence", sequenceName = "bike_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bike_sequence")
    private BigInteger id;

    @Column(name = "fk_client_id")
    private BigInteger clientId;

    @Column(name = "model")
    private String model;

    @Column(name = "last_service")
    private LocalDateTime lastService;

}
