package com.mmplus.bestprice.service;

import java.util.List;
import java.util.Optional;

import com.mmplus.bestprice.entity.HotPriceOrder;

public interface HotPriceOrderService {

	HotPriceOrder saveOrUpdateHotPriceOrder(HotPriceOrder hotPriceOrder);

	void deleteHotPriceOrder(Long id);

	List<HotPriceOrder> findAll();

	Optional<HotPriceOrder> findByid(Long id);
}
