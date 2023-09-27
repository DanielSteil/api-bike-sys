package br.com.lvds.BikeSys.domain.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import br.com.lvds.BikeSys.domain.model.Bike;

public interface ClientBikesDTO {

    BigInteger getId();
    String getName();
    String getNumber();
    List<Bike> getBikes();
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
    Boolean getActive();
    
}
