package com.mmplus.bestprice.service;

import com.mmplus.bestprice.entity.HotPriceOrder;
import com.mmplus.bestprice.repository.HotPriceOrderRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class HotPriceOrderImpl implements HotPriceOrderService {
	
	private HotPriceOrderRepository hotPriceOrderRepository;
	  
	public HotPriceOrderImpl(HotPriceOrderRepository hotPriceOrderRepository) {
		this.hotPriceOrderRepository = hotPriceOrderRepository;
	}

	@Override
	public HotPriceOrder saveOrUpdateHotPriceOrder(HotPriceOrder hotPriceOrder) {
		return hotPriceOrderRepository.save(hotPriceOrder);
	}

	@Override
	public void deleteHotPriceOrder(Long id) {
		hotPriceOrderRepository.deleteById(id);;
	}

	@Override
	public List<HotPriceOrder> findAll() {
		return hotPriceOrderRepository.findAll();
	}

	@Override
	public HotPriceOrder findByid(Long id) {
		return hotPriceOrderRepository.getOne(id);
	}
}
