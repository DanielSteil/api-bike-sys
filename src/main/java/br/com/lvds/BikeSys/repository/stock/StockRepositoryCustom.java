package br.com.lvds.BikeSys.repository.stock;

import org.springframework.data.domain.Page;

import br.com.lvds.BikeSys.domain.criteria.PageCriteria;
import br.com.lvds.BikeSys.domain.dto.StockDTO;

public interface StockRepositoryCustom {
    
    Page<StockDTO> fetchStock(StockDTO filter, PageCriteria criteria);

}
