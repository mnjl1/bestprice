package com.mmplus.bestprice.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmplus.bestprice.entity.HotPriceOrder;
import com.mmplus.bestprice.service.HotPriceOrderService;
import com.mmplus.bestprice.service.HotPriceScheduleService;

@Controller
@RequestMapping()
public class HotPriceOrderController {

	private HotPriceOrderService hotPriceOrderService;
	private HotPriceScheduleService hotPriceScheduleService;

	public HotPriceOrderController(HotPriceOrderService hotPriceOrderService, HotPriceScheduleService hotPriceScheduleService) {
		this.hotPriceOrderService = hotPriceOrderService;
		this.hotPriceScheduleService = hotPriceScheduleService;
	}

	@RequestMapping("/hot-price-order-form")
	public String hotPriceOrderForm(Model model, HotPriceOrder hotPriceOrder) {
		model.addAttribute("hotPriceOrder", hotPriceOrder);
		return "hot-price-order-form";
	}
	
	@RequestMapping("/mmplus/hot-price-order/{id}")
	public String processHotPriceOrder(Model model, @PathVariable(value = "id") Long id) {
		HotPriceOrder hotPriceOrder = hotPriceOrderService.findByid(id);
		LocalDate hotPriceSchedule = hotPriceOrder.getHotPriceSchedule().getHotPriceStartDate();
		model.addAttribute("hotPriceOrder", hotPriceOrder);
		model.addAttribute("hotPriceSchedule", hotPriceSchedule);
		return "hot-price-order";
	}

}
