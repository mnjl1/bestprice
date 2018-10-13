package com.mmplus.bestprice.repository;

import com.mmplus.bestprice.entity.HotPriceSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotPriceScheduleRepository extends JpaRepository<HotPriceSchedule, Long> {
}
