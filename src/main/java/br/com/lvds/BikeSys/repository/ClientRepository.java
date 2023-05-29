package br.com.lvds.BikeSys.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lvds.BikeSys.domain.model.Client;

public interface ClientRepository extends JpaRepository<Client, BigInteger> {
    
    

}
