package br.com.lvds.BikeSys.repository.client;

import java.util.List;

import br.com.lvds.BikeSys.domain.dto.ClientDTO;

public interface ClientRepositoryCustom {
    
    List<ClientDTO> getClients(ClientDTO filter);

}
