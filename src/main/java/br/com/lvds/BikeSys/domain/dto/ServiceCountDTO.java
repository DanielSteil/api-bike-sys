package br.com.lvds.BikeSys.domain.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder(toBuilder = true)
public class ServiceCountDTO implements Serializable {
    
    private Integer servicesDay;
    
    private Integer servicesWeek;

    private Integer servicesMonth;

}
