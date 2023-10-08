package br.com.lvds.BikeSys.domain.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder(toBuilder = true)
public class LastServiceDTO implements Serializable {
    
    private String clientName;

    private String serviceDescription;

    private LocalDateTime serviceDate;

    public LastServiceDTO(String clientName, String serviceDescription, LocalDateTime serviceDate) {
        this.clientName = clientName;
        this.serviceDescription = serviceDescription;
        this.serviceDate = serviceDate;
    }

}

