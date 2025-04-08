package br.com.lvds.BikeSys.repository.client;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.lvds.BikeSys.domain.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, BigInteger>, ClientRepositoryCustom {
    
    @Query(value = "SELECT COUNT(c.id) FROM clients c", nativeQuery=true)
    Long getTotalClients();    

}
