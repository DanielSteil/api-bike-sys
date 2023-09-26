package br.com.lvds.BikeSys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lvds.BikeSys.domain.dto.BikeDTO;
import br.com.lvds.BikeSys.domain.model.Bike;
import br.com.lvds.BikeSys.domain.response.GenericResponse;
import br.com.lvds.BikeSys.service.BikeService;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikeController {
    
    @Autowired
    private BikeService service;

    @PostMapping()
    public ResponseEntity<?> saveBike(@RequestBody Bike bike) throws Exception {
        return ResponseEntity.ok(new GenericResponse<>(
                service.saveBike(bike)
            ));
    }

}
