package br.com.lvds.BikeSys.repository.service;

import java.util.List;

import br.com.lvds.BikeSys.domain.dto.LastServiceDTO;

public interface ServiceRepositoryCustom {

    List<LastServiceDTO> buscaUltimosServicos();
    
}
