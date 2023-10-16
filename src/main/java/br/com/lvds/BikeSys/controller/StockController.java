package br.com.lvds.BikeSys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lvds.BikeSys.service.StockService;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {
    
    @Autowired
    private StockService stockService;

    @GetMapping()
    public ResponseEntity<?> getStocks() throws Exception {
        return ResponseEntity.ok(stockService.getStocks());
    }

}
