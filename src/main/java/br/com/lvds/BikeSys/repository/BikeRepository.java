package br.com.lvds.BikeSys.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lvds.BikeSys.domain.model.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, BigInteger> {
    
}
