package br.com.lvds.BikeSys.controller;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lvds.BikeSys.domain.model.Client;
import br.com.lvds.BikeSys.domain.response.GenericResponse;
import br.com.lvds.BikeSys.service.ClientService;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    
    @Autowired
    ClientService service;

    public ResponseEntity<?> saveClient(@RequestBody Client client) throws Exception {
        return ResponseEntity.ok(
                new GenericResponse(service.saveClient(client)
            ));
    }

}
