package br.com.lvds.BikeSys.repository.service;

import java.math.BigInteger;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.lvds.BikeSys.domain.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, BigInteger>, ServiceRepositoryCustom {
    
    @Query(value = """
            SELECT COUNT(s.*)
            FROM services s 
            WHERE service_date > :startDate
            AND service_date < :endDate """, nativeQuery = true)
    Integer countServices(@Param("startDate") LocalDate startDate,
                          @Param("endDate") LocalDate endDate);

}
