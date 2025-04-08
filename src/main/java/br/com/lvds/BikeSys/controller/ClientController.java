package br.com.lvds.BikeSys.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lvds.BikeSys.domain.criteria.PageCriteria;
import br.com.lvds.BikeSys.domain.dto.ClientDTO;
import br.com.lvds.BikeSys.domain.response.GenericPageableResponse;
import br.com.lvds.BikeSys.domain.response.GenericResponse;
import br.com.lvds.BikeSys.service.ClientService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    
    @Autowired
    ClientService service;

    @PostMapping()
    public ResponseEntity<?> saveClient(@RequestBody ClientDTO client) throws Exception {
        return ResponseEntity.ok(new GenericResponse<>(service.saveClient(client)));
    }

    @GetMapping("/dashboards")
    public ResponseEntity<?> getDashboardsInfos() throws Exception {
        return ResponseEntity.ok(new GenericResponse<>(service.getClientDashboardsInfos()));
    }

    @GetMapping()
    public ResponseEntity<?> getClients(@Valid ClientDTO filter, @Valid PageCriteria criteria) throws Exception {
        return ResponseEntity.ok(new GenericPageableResponse<>(service.getClients(filter, criteria)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchClient(@PathVariable("id") BigInteger clientId, @RequestBody ClientDTO clientDto) throws Exception {
        return ResponseEntity.ok(new GenericResponse<>(service.patchClient(clientId, clientDto)));
    } 

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable("id") BigInteger clientId) throws  Exception {
        return ResponseEntity.ok(new GenericResponse<>(service.getClientById(clientId)));
    }

}
