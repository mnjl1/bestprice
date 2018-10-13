package com.mmplus.bestprice.service;

import com.mmplus.bestprice.entity.HotPriceSchedule;
import com.mmplus.bestprice.repository.HotPriceScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotPriceScheduleServiceImpl implements HotPriceScheduleService {

    private HotPriceScheduleRepository hotPriceScheduleRepository;

    public HotPriceScheduleServiceImpl(HotPriceScheduleRepository hotPriceScheduleRepository) {
        this.hotPriceScheduleRepository = hotPriceScheduleRepository;
    }

    @Override
    public HotPriceSchedule saveOrUpdateBestPriceEvent(HotPriceSchedule hotPriceSchedule) {
        return hotPriceScheduleRepository.save(hotPriceSchedule);
    }

    //ToDo implement sorting by start date
    @Override
    public List<HotPriceSchedule> findAll() {
        return hotPriceScheduleRepository.findAll();
    }

	@Override
	public HotPriceSchedule findById(Long id) {
		return hotPriceScheduleRepository.getOne(id);
	}
}
