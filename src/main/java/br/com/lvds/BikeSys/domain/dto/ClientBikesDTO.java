package br.com.lvds.BikeSys.domain.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONObject;

import br.com.lvds.BikeSys.domain.model.Bike;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder(toBuilder = true)
public class ClientBikesDTO implements Serializable {

    private BigInteger id;
    private String name;
    private String number;
    private JSONObject bikes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean active;

    public ClientBikesDTO(BigInteger id, String name, String number, JSONObject bikes, LocalDateTime createdAt,
            LocalDateTime updatedAt, Boolean active) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.bikes = bikes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
    }

}
