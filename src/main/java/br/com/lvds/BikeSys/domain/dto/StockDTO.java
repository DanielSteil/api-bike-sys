package br.com.lvds.BikeSys.domain.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import br.com.lvds.BikeSys.domain.model.Stock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder(toBuilder = true)
public class StockDTO implements Serializable {
    
    private BigInteger id;

    private String description;

    private Long amount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Stock patch(Stock stock) {
        if(this.description != null && !this.description.isEmpty())
            stock.setDescription(this.description);
        if(this.amount != null)
            stock.setAmount(this.amount);
        return stock;
    }

}
