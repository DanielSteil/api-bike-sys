package br.com.lvds.BikeSys.repository.stock;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lvds.BikeSys.domain.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, BigInteger>, StockRepositoryCustom {
    
}
