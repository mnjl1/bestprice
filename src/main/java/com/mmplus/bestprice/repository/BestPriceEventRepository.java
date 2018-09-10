package com.mmplus.bestprice.repository;

import com.mmplus.bestprice.entity.BestPriceEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestPriceEventRepository extends JpaRepository<BestPriceEvent, Long> {
}
