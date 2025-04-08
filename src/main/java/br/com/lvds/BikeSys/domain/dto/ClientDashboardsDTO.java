package br.com.lvds.BikeSys.domain.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder(toBuilder=true)
public class ClientDashboardsDTO implements Serializable {
    
    private Long totalClients;

    private Long totalBikes;

}
