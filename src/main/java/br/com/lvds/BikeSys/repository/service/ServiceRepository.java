package br.com.lvds.BikeSys.repository.service;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lvds.BikeSys.domain.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, BigInteger>, ServiceRepositoryCustom {
    
}
