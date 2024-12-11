package br.com.lvds.BikeSys.domain.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import br.com.lvds.BikeSys.domain.dto.ClientDTO;
import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// @SqlResultSetMapping(name= STATEMENT_SQLMAP, classes = {
//     @ConstructorResult(targetClass = StatementDto.class,
//         columns = {
//             @ColumnResult(name="author_name",type = String.class),
//             @ColumnResult(name="create_time",type = Date.class)
//         }
//     )
// }) 
@SqlResultSetMapping(name = "full_client", classes =  {
    @ConstructorResult(targetClass = ClientDTO.class,
        columns = {
            @ColumnResult(name = "id", type = BigInteger.class),
            @ColumnResult(name = "name", type = String.class),
            @ColumnResult(name = "number", type = String.class),
            @ColumnResult(name = "createdAt", type = LocalDateTime.class),
            @ColumnResult(name = "updatedAt", type = LocalDateTime.class)
        })
})
@Entity
@Table(name = "clients")
@Data
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
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

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "active")
    private Boolean active;

    @PrePersist
    @PreUpdate
    private void prePersist() {
        if(this.createdAt == null) {
            this.createdAt = LocalDateTime.now(ZoneId.of("Brazil/East"));
            this.active = Boolean.TRUE;
        }
        this.updatedAt = LocalDateTime.now(ZoneId.of("Brazil/East"));
    }

}
