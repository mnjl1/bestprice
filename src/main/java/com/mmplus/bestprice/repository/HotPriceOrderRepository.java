package com.mmplus.bestprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mmplus.bestprice.entity.HotPriceOrder;

@Repository
public interface HotPriceOrderRepository extends JpaRepository<HotPriceOrder, Long > {

}
