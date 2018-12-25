package com.mmplus.bestprice.controller;

import com.mmplus.bestprice.entity.HotPriceOrder;
import com.mmplus.bestprice.service.HotPriceOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping()
public class HotPriceOrderController {

	private HotPriceOrderService hotPriceOrderService;

	public HotPriceOrderController(HotPriceOrderService hotPriceOrderService) {
		this.hotPriceOrderService = hotPriceOrderService;
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
