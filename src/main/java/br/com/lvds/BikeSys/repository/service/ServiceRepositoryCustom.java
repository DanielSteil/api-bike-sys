package br.com.lvds.BikeSys.repository.service;

import java.util.List;

import br.com.lvds.BikeSys.domain.dto.ServiceFullDTO;

public interface ServiceRepositoryCustom {

    List<ServiceFullDTO> buscaUltimosServicos(Long limitSize);

}
