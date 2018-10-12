package com.mmplus.bestprice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mmplus.bestprice.entity.HotPriceSchedule;
import com.mmplus.bestprice.entity.HotPriceOrder;
import com.mmplus.bestprice.service.HotPriceScheduleService;
import com.mmplus.bestprice.service.HotPriceOrderService;

@Controller
public class HotPriceOrderController {
	
	@Autowired
	private HotPriceOrderService hotPriceOrderService;
	
	@Autowired
	private HotPriceScheduleService hotPriceScheduleService;
	
	@RequestMapping(value="/create-hot-price-order-form/{id}", method=RequestMethod.GET)
	public String saveOrUpdateOrder(Model model, @PathVariable(value="id") Long id) {
		HotPriceOrder hotPriceOrder = new HotPriceOrder();
		HotPriceSchedule hotPriceSchedule = hotPriceScheduleService.findById(id);
		model.addAttribute("hotPriceSchedule", hotPriceSchedule);
		model.addAttribute("hotPriceOrder", hotPriceOrder);
		
		return "hot-price-order-form";
	}
	
	@RequestMapping("/hot-price-order-form")
	public String hotPriceOrderForm(Model model, HotPriceOrder hotPriceOrder) {
		model.addAttribute("hotPriceOrder", hotPriceOrder);
		return "hot-price-order-form";
	}
	
	@RequestMapping("/process-hot-price-order-form")
	public String processHotPriceForm(Model model, HotPriceOrder hotPriceOrder){
		model.addAttribute("hotPriceOrder", hotPriceOrder);
		hotPriceOrderService.saveOrUpdateHotPriceOrder(hotPriceOrder);
		
		System.out.println("after saving order: " +hotPriceOrder);
		return "hot-price-schedule-list";
	}
}
