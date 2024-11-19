package br.com.lvds.BikeSys.repository.service;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.lvds.BikeSys.domain.criteria.PageCriteria;
import br.com.lvds.BikeSys.domain.dto.ServiceDTO;

public interface ServiceRepositoryCustom {

    List<ServiceDTO> getLastServices(Long limitSize);

    Page<ServiceDTO> fetchServices(ServiceDTO filter, PageCriteria criteria);

}
