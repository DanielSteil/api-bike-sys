package br.com.lvds.BikeSys.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lvds.BikeSys.domain.criteria.PageCriteria;
import br.com.lvds.BikeSys.domain.dto.StockDTO;
import br.com.lvds.BikeSys.domain.response.GenericPageableResponse;
import br.com.lvds.BikeSys.domain.response.GenericResponse;
import br.com.lvds.BikeSys.service.StockService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {
    
    @Autowired
    private StockService stockService;

    @GetMapping()
    public ResponseEntity<?> getStocks(@Valid StockDTO filter, @Valid PageCriteria criteria) throws Exception {
        return ResponseEntity.ok(new GenericPageableResponse<>(stockService.getStocks(filter, criteria)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStockItem(@PathVariable("id") BigInteger id) throws Exception {
        return ResponseEntity.ok(new GenericResponse<>(stockService.getStockById(id)));
    }

    @PostMapping()
    public ResponseEntity<?> createStock(@RequestBody StockDTO stock) throws Exception {
        return ResponseEntity.ok(new GenericResponse<>(stockService.create(stock)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchStock(@PathVariable("id") BigInteger id, @RequestBody StockDTO stockDTO) throws Exception {
        return ResponseEntity.ok(new GenericResponse<>(stockService.patch(id, stockDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable("id") BigInteger id) throws Exception {
        return ResponseEntity.ok(new GenericResponse<>(stockService.deleteStock(id)));
    }

}
