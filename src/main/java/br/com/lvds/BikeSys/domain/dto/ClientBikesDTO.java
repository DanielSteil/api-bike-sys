package br.com.lvds.BikeSys.domain.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

public interface ClientBikesDTO {

    BigInteger getId();
    String getName();
    String getNumber();
    List<String> getBikes();
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
    Boolean getActive();

}
