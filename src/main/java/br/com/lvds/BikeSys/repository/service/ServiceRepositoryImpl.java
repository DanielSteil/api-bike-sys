package br.com.lvds.BikeSys.repository.service;

import org.springframework.data.domain.Page;

import br.com.lvds.BikeSys.domain.criteria.PageCriteria;
import br.com.lvds.BikeSys.domain.dto.ServiceDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ServiceRepositoryImpl implements ServiceRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public Page<ServiceDTO> buscaUltimosServicos(ServiceDTO filter, PageCriteria criteria) {
        StringBuilder sql = new StringBuilder();
        sql.append("""
            SELECT new br.com.lvds.BikeSys.domain.dto.LastServiceDTO()
            FROM Service s
            INNER 
        """);

        throw new UnsupportedOperationException("Unimplemented method 'buscaUltimosServicos'");
    }
    
}
