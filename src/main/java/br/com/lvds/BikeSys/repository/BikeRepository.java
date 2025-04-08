package br.com.lvds.BikeSys.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.lvds.BikeSys.domain.model.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, BigInteger> {
 
    @Query(value = "SELECT COUNT(b.id) FROM bikes b", nativeQuery = true)
    Long getTotalBikes();

    @Query(value = "SELECT b.* FROM bikes b WHERE b.fk_client_id = :clientId", nativeQuery = true)
    List<Bike> getBikesByClientId(@Param("clientId") BigInteger clientId);

}
