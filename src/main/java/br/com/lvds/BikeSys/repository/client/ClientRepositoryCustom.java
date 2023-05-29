package br.com.lvds.BikeSys.repository.client;

import org.springframework.data.domain.Page;

import br.com.lvds.BikeSys.domain.criteria.PageCriteria;
import br.com.lvds.BikeSys.domain.dto.ClientDTO;

public interface ClientRepositoryCustom {
    
    public Page<ClientDTO> getClients(ClientDTO filter, PageCriteria criteria);

}
