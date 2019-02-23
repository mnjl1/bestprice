package com.mmplus.bestprice.service;

import com.mmplus.bestprice.entity.HotPriceSchedule;

import java.util.List;
import java.util.Optional;

public interface HotPriceScheduleService {

    HotPriceSchedule saveOrUpdateBestPriceEvent(HotPriceSchedule hotPriceSchedule);

    List<HotPriceSchedule> findAll();
    
    Optional<HotPriceSchedule> findById(Long id);

}
