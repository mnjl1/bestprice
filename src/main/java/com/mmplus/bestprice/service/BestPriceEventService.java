package com.mmplus.bestprice.service;

import com.mmplus.bestprice.entity.BestPriceEvent;

import java.util.List;

public interface BestPriceEventService {

    BestPriceEvent saveOrUpdateBestPriceEvent(BestPriceEvent bestPriceEvent);

    BestPriceEvent findBestPriceEventById(Long id);

    List<BestPriceEvent> findAll();

}
