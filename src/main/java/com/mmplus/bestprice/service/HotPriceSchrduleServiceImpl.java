package com.mmplus.bestprice.service;

import com.mmplus.bestprice.entity.HotPriceSchedule;
import com.mmplus.bestprice.repository.HotPriceScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotPriceSchrduleServiceImpl implements HotPriceScheduleService {

    private HotPriceScheduleRepository hotPriceScheduleRepository;

    public HotPriceSchrduleServiceImpl(HotPriceScheduleRepository hotPriceScheduleRepository) {
        this.hotPriceScheduleRepository = hotPriceScheduleRepository;
    }

    @Override
    public HotPriceSchedule saveOrUpdateHotPriceSchedule(HotPriceSchedule hotPriceSchedule) {
        return hotPriceScheduleRepository.save(hotPriceSchedule);
    }
    
    @Override
    public List<HotPriceSchedule> findAll() {
        return hotPriceScheduleRepository.findAll();
    }

	@Override
	public HotPriceSchedule findById(Long id) {
		return hotPriceScheduleRepository.getOne(id);
	}
}
