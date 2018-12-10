package com.mmplus.bestprice.service;

import java.util.List;

import com.mmplus.bestprice.entity.HotPriceOrder;

public interface HotPriceOrderService {

	HotPriceOrder saveOrUpdateHotPriceOrder(HotPriceOrder hotPriceOrder);

	void deleteHotPriceOrder(Long id);

	List<HotPriceOrder> findAll();

	HotPriceOrder findByid(Long id);
}
