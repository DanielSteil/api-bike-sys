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
@Table(name = "stocks")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder(toBuilder = true)
public class Stock implements Serializable {
    
    @Id
    @Column(nullable = false)
    @SequenceGenerator(name = "stock_sequence", sequenceName = "stock_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_sequence")
    private BigInteger id;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
