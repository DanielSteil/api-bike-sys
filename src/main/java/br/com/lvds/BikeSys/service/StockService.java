package br.com.lvds.BikeSys.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.lvds.BikeSys.domain.criteria.PageCriteria;
import br.com.lvds.BikeSys.domain.dto.StockDTO;
import br.com.lvds.BikeSys.domain.mapper.StockMapper;
import br.com.lvds.BikeSys.domain.model.Stock;
import br.com.lvds.BikeSys.repository.stock.StockRepository;

@Service
public class StockService {
    
    @Autowired
    private StockRepository stockRepository;

    public Page<StockDTO> getStocks(StockDTO filter, PageCriteria criteria) throws Exception {
        return stockRepository.fetchStock(filter, criteria);
    }

    public StockDTO getStockById(BigInteger id) throws Exception {
        return StockMapper.fromEntity(stockRepository.findById(id).orElse(null));
    }

    public StockDTO create(StockDTO stock) throws Exception {
        return StockMapper.fromEntity(stockRepository.save(StockMapper.fromDTO(stock)));
    }

    public StockDTO patch(BigInteger id, StockDTO stockDTO) throws Exception {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new Exception("Stock not found!"));
        return StockMapper.fromEntity(stockRepository.save(stockDTO.patch(stock)));
    }

    public String deleteStock(BigInteger id) throws Exception {
        stockRepository.deleteById(id);
        return "Item removed!";
    }

}
