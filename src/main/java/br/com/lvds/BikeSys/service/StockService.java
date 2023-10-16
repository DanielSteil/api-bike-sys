package br.com.lvds.BikeSys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lvds.BikeSys.domain.model.Stock;
import br.com.lvds.BikeSys.repository.StockRepository;

@Service
public class StockService {
    
    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getStocks() throws Exception {
        return stockRepository.findAll();
    }

}
