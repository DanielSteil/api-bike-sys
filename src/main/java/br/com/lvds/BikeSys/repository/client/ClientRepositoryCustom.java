package br.com.lvds.BikeSys.repository.client;

import java.util.List;


import br.com.lvds.BikeSys.domain.criteria.PageCriteria;
import br.com.lvds.BikeSys.domain.dto.ClientBikesDTO;
import br.com.lvds.BikeSys.domain.dto.ClientDTO;

public interface ClientRepositoryCustom {
    
    List<ClientBikesDTO> getClients(ClientDTO filter, PageCriteria criteria);

}
