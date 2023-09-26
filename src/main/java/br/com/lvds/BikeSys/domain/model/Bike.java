package br.com.lvds.BikeSys.domain.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliets_id")
    private Client client;

    @Column(name = "model")
    private String model;

    @Column(name = "last_service")
    private LocalDateTime lastService;

    @Column(name = "services", columnDefinition = "jsonb[]")
    private List<Service> services;

}
