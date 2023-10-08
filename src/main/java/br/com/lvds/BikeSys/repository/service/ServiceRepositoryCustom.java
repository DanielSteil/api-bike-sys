package br.com.lvds.BikeSys.repository.service;

import org.springframework.data.domain.Page;

import br.com.lvds.BikeSys.domain.criteria.PageCriteria;
import br.com.lvds.BikeSys.domain.dto.ServiceDTO;

public interface ServiceRepositoryCustom {

    Page<ServiceDTO> buscaUltimosServicos(ServiceDTO filter, PageCriteria criteria);
    
}
