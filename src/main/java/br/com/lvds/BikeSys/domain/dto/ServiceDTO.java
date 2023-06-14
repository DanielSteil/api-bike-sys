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

    @Id
    @Column(nullable = false)
    @SequenceGenerator(name = "bike_sequence", sequenceName = "bike_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bike_sequence")
    private BigInteger id;

    @Column(name = "description")
    private String description;

    @Column(name = "value")
    private Double value;

    @Column(name = "service_date")
    private LocalDateTime serviceDate;

}
