package br.com.lvds.BikeSys.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lvds.BikeSys.domain.dto.ServiceDTO;
import br.com.lvds.BikeSys.service.ServiceService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/services")
public class ServiceController {
    
    @Autowired
    private ServiceService serviceService;

    @PostMapping()
    public ResponseEntity<?> saveService(@RequestBody ServiceDTO serivice) throws Exception {
        return ResponseEntity.ok(serviceService.createService(serivice));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getServiceById(@PathVariable("id") BigInteger id) throws Exception {
        return ResponseEntity.ok(serviceService.getServiceById(id));
    }

    @GetMapping("/lasts")
    public ResponseEntity<?> getLastServices(@Valid Long limit) throws Exception {
        return ResponseEntity.ok(serviceService.getLastServices(limit));
    }

    @GetMapping("/cards")
    public ResponseEntity<?> getServicesCardsInfo() throws Exception {
        return ResponseEntity.ok(serviceService.getServicesCardsInfo());
    }

}
