package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    List<Stock> findByStCodeAndStDateBetween(String stCode, LocalDate startDate, LocalDate endDate);

    List<Stock> findByStCodeAndStCloseGreaterThan(String stCode, BigDecimal price);

    List<Stock> findTop3ByOrderByStVolumeDesc();

    List<Stock> findTop3ByStCodeOrderByStCloseAsc(String stCode);
}
