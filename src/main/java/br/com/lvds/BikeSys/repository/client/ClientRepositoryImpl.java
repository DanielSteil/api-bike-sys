package br.com.lvds.BikeSys.repository.client;

import org.springframework.data.domain.Page;

import br.com.lvds.BikeSys.domain.criteria.PageCriteria;
import br.com.lvds.BikeSys.domain.dto.ClientDTO;

public class ClientRepositoryImpl implements ClientRepositoryCustom {

    @Override
    public Page<ClientDTO> getClients(ClientDTO filter, PageCriteria criteria) {
        StringBuilder sql = new StringBuilder();
        return null;
    }
    
}
