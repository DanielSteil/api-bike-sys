package br.com.lvds.BikeSys.repository.service;

import java.util.List;

import br.com.lvds.BikeSys.domain.dto.ServiceDTO;

public interface ServiceRepositoryCustom {

    List<ServiceDTO> buscaUltimosServicos();
    
}
