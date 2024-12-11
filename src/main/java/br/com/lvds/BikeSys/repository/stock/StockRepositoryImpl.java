package br.com.lvds.BikeSys.repository.stock;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import br.com.lvds.BikeSys.domain.criteria.PageCriteria;
import br.com.lvds.BikeSys.domain.dto.StockDTO;
import br.com.lvds.BikeSys.domain.mapper.StockMapper;
import br.com.lvds.BikeSys.domain.model.Stock;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class StockRepositoryImpl implements StockRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<StockDTO> fetchStock(StockDTO filter, PageCriteria criteria) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT s.* ");
        sql.append("FROM stocks s ");
        sql.append("WHERE 1=1 ");
        if(filter.getDescription() != null && !filter.getDescription().isEmpty()) {
            sql.append("AND s.description ILIKE :description ");
        }
        Query queryCount = em.createNativeQuery(sql.toString().replace("s.*", "COUNT(s.id)"));
        sql.append("ORDER BY s.description ASC ");
        Query query = em.createNativeQuery(sql.toString(), Stock.class);
        if(filter.getDescription() != null && !filter.getDescription().isEmpty()) {
            query.setParameter("description", "%"+filter.getDescription()+"%");
        }
        Long totalElements = Long.valueOf(queryCount.getFirstResult());
        query.setMaxResults(criteria.getPageSize());
        query.setFirstResult(criteria.getPageIndex() * criteria.getPageSize());
        return new PageImpl<>(StockMapper.fromEntities(query.getResultList()), PageCriteria.getPageRequest(criteria), totalElements);
        
    }
    
}
