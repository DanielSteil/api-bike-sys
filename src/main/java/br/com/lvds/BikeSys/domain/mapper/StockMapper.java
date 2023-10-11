package br.com.lvds.BikeSys.domain.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.lvds.BikeSys.domain.dto.StockDTO;
import br.com.lvds.BikeSys.domain.model.Stock;

public class StockMapper {
    
    public static Stock fromDTO(StockDTO stock) {
        return Stock.builder()
                .id(stock.getId())
                .description(stock.getDescription())
                .amount(stock.getAmount())
                .createdAt(stock.getCreatedAt())
                .updatedAt(stock.getUpdatedAt())
            .build();
    }

    public static StockDTO fromEntity(Stock stock) {
        return StockDTO.builder()
                .id(stock.getId())
                .description(stock.getDescription())
                .amount(stock.getAmount())
                .createdAt(stock.getCreatedAt())
                .updatedAt(stock.getUpdatedAt())
            .build();
    }

    public static List<StockDTO> fromEntities(List<Stock> stocks) {
        return stocks.stream().map((stock) -> fromEntity(stock)).collect(Collectors.toList());
    }

}   
