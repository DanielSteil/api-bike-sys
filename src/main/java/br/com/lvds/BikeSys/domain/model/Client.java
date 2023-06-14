package br.com.lvds.BikeSys.domain.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor @AllArgsConstructor 
@Builder(toBuilder = true)
public class Client implements Serializable {

    @Id
    @Column(nullable = false)
    @SequenceGenerator(name = "client_sequence", sequenceName = "client_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_sequence")
    private BigInteger id;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private String number;

    @Column(name = "bikes", columnDefinition = "jsonb[]")
    private List<Bike> bikes;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "active")
    private Boolean active;

}
