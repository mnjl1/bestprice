package com.mmplus.bestprice.service;

import com.mmplus.bestprice.entity.BestPriceEvent;
import com.mmplus.bestprice.repository.BestPriceEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BestPriceEventServiceImpl implements BestPriceEventService {

    private BestPriceEventRepository bestPriceEventRepository;

    public BestPriceEventServiceImpl(BestPriceEventRepository bestPriceEventRepository) {
        this.bestPriceEventRepository = bestPriceEventRepository;
    }

    @Override
    public BestPriceEvent saveOrUpdateBestPriceEvent(BestPriceEvent bestPriceEvent) {
        return bestPriceEventRepository.save(bestPriceEvent);
    }

    @Override
    public BestPriceEvent findBestPriceEventById(Long id) {
        return bestPriceEventRepository.getOne(id);
    }

    //todo implement sorting by start date
    @Override
    public List<BestPriceEvent> findAll() {
        return bestPriceEventRepository.findAll();
    }
}
