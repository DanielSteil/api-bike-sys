package br.com.lvds.BikeSys.repository.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

        @Query(value = """
                SELECT SUM(s.value)
                FROM services s 
                WHERE service_date > :startDate""", nativeQuery = true)
        Double calculateTotalAmountFromDate(@Param("startDate") LocalDate startDate);

        @Query(value = """
                SELECT s.service_date
                FROM services s 
                ORDER BY service_date DESC LIMIT 1""", nativeQuery = true)
        LocalDate getDateLastService();        

}
