package com.mmplus.bestprice.service;

import com.mmplus.bestprice.entity.HotPriceSchedule;

import java.util.List;

import org.springframework.stereotype.Service;

public interface HotPriceScheduleService {

    HotPriceSchedule saveOrUpdateHotPriceSchedule(HotPriceSchedule hotPriceSchedule);

    List<HotPriceSchedule> findAll();
    
    HotPriceSchedule findById(Long id);
}
