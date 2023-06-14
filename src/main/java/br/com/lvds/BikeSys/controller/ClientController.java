package br.com.lvds.BikeSys.controller;

import br.com.lvds.BikeSys.domain.criteria.PageCriteria;
import br.com.lvds.BikeSys.domain.dto.ClientDTO;
import jakarta.validation.Valid;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.lvds.BikeSys.domain.model.Client;
import br.com.lvds.BikeSys.domain.response.GenericResponse;
import br.com.lvds.BikeSys.service.ClientService;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    
    @Autowired
    ClientService service;

    @PostMapping()
    public ResponseEntity<?> saveClient(@RequestBody Client client) throws Exception {
        return ResponseEntity.ok(
                new GenericResponse(service.saveClient(client)
            ));
    }

    @GetMapping()
    public ResponseEntity<?> getClients(@Valid ClientDTO filter,
                                        @Valid PageCriteria criteria) throws Exception {
        return ResponseEntity.ok(
                new GenericResponse<>(service.getClient(filter, criteria)
            ));
    }

}
