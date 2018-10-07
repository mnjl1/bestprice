package com.mmplus.bestprice.service;

import com.mmplus.bestprice.entity.BestPriceEvent;

import java.util.List;

import org.springframework.stereotype.Service;

public interface BestPriceEventService {

    BestPriceEvent saveOrUpdateBestPriceEvent(BestPriceEvent bestPriceEvent);

    BestPriceEvent findBestPriceEventById(Long id);

    List<BestPriceEvent> findAll();
    
    BestPriceEvent findById(Long id);

}
