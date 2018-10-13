package com.mmplus.bestprice.service;

import com.mmplus.bestprice.entity.HotPriceSchedule;

import java.util.List;

public interface HotPriceScheduleService {

    HotPriceSchedule saveOrUpdateBestPriceEvent(HotPriceSchedule hotPriceSchedule);

    List<HotPriceSchedule> findAll();
    
    HotPriceSchedule findById(Long id);

}
