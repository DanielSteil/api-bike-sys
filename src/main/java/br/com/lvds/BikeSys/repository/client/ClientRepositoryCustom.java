package br.com.lvds.BikeSys.repository.client;

import org.springframework.data.domain.Page;

import br.com.lvds.BikeSys.domain.criteria.PageCriteria;
import br.com.lvds.BikeSys.domain.dto.ClientBikesDTO;
import br.com.lvds.BikeSys.domain.dto.ClientDTO;

public interface ClientRepositoryCustom {
    
    Page<ClientBikesDTO> getClients(ClientDTO filter, PageCriteria criteria);

}
