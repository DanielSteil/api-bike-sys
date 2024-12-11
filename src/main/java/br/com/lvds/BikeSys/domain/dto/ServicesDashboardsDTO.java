package br.com.lvds.BikeSys.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder(toBuilder = true)
public class ServicesDashboardsDTO implements Serializable {
    
    private Integer servicesWeek;
    
    private Integer servicesMonth;

    private Double totalAmountMonth;

    private LocalDate dateLastService;

}
