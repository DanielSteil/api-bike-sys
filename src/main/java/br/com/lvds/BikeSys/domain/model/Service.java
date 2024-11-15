package br.com.lvds.BikeSys.domain.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;

import br.com.lvds.BikeSys.domain.dto.ServiceFullDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.SqlResultSetMapping;
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
@SqlResultSetMapping(
    name = "servicesFull",
    classes = @ConstructorResult(targetClass = ServiceFullDTO.class,
        columns = {
            @ColumnResult(name="id", type = BigInteger.class),
            @ColumnResult(name="clientName", type = String.class),
            @ColumnResult(name="clientBike", type = String.class),
            @ColumnResult(name="serviceDate", type = LocalDateTime.class),
            @ColumnResult(name="totalAmount", type = Double.class)
        }
    )
)
public class Service implements Serializable {

    @Id
    @Column(nullable = false)
    @SequenceGenerator(name = "service_sequence", sequenceName = "service_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_sequence")
    private BigInteger id;

    @Column(name = "description")
    private String description;

    @Column(name = "value")
    private Double value;

    @Column(name = "fk_bike_id")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Bike bike;

    @Column(name = "service_date")
    private LocalDateTime serviceDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    @PreUpdate
    private void prePersist() {
        if(this.createdAt == null) {
            this.createdAt = LocalDateTime.now(ZoneId.of("Brazil/East"));
        }
        this.updatedAt = LocalDateTime.now(ZoneId.of("Brazil/East"));
    }

}
