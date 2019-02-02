package com.mmplus.bestprice.controller;

import com.mmplus.bestprice.entity.HotPriceOrder;
import com.mmplus.bestprice.entity.HotPriceSchedule;
import com.mmplus.bestprice.entity.OrderStatus;
import com.mmplus.bestprice.service.HotPriceOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping()
public class HotPriceOrderController {

	private HotPriceOrderService hotPriceOrderService;

	public HotPriceOrderController(HotPriceOrderService hotPriceOrderService) {
		this.hotPriceOrderService = hotPriceOrderService;
	}
	
	@RequestMapping("/mmplus/hot-price-order-form/{id}")
	public String processHotPriceOrder(Model model, @PathVariable(value = "id") Long id) {
		HotPriceOrder hotPriceOrder = hotPriceOrderService.findByid(id);
		HotPriceSchedule hotPriceSchedule = hotPriceOrder.getHotPriceSchedule();
		model.addAttribute("hotPriceOrder", hotPriceOrder);
		model.addAttribute("hotPriceSchedule", hotPriceSchedule);
		model.addAttribute("statuses", Arrays.asList(OrderStatus.values()));

		return "hot-price-order-form";
	}
}
