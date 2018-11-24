package com.mmplus.bestprice.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mmplus.bestprice.entity.HotPriceOrder;
import com.mmplus.bestprice.entity.HotPriceSchedule;
import com.mmplus.bestprice.service.HotPriceOrderService;
import com.mmplus.bestprice.service.HotPriceScheduleService;

@Controller
public class HotPriceOrderController {

	private HotPriceOrderService hotPriceOrderService;
	private HotPriceScheduleService hotPriceScheduleService;

	public HotPriceOrderController(HotPriceOrderService hotPriceOrderService, HotPriceScheduleService hotPriceScheduleService) {
		this.hotPriceOrderService = hotPriceOrderService;
		this.hotPriceScheduleService = hotPriceScheduleService;
	}

	@RequestMapping(value = "/create-hot-price-order-form/{id}", method = RequestMethod.GET)
	public String saveOrUpdateOrder(Model model, @PathVariable(value = "id") Long id) {
		HotPriceOrder hotPriceOrder = new HotPriceOrder();
		HotPriceSchedule hotPriceSchedule = hotPriceScheduleService.findById(id);
		model.addAttribute("hotPriceOrder", hotPriceOrder);
		model.addAttribute("hotPriceEvent", hotPriceSchedule);
		return "hot-price-order-form";
	}

	@RequestMapping("/hot-price-order-form")
	public String hotPriceOrderForm(Model model, HotPriceOrder hotPriceOrder) {
		model.addAttribute("hotPriceOrder", hotPriceOrder);
		return "hot-price-order-form";
	}

	@RequestMapping("/process-hot-price-order-form")
	public String processHotPriceForm(Model model, HotPriceOrder hotPriceOrder) {
		model.addAttribute("hotPriceOrder", hotPriceOrder);
		hotPriceOrderService.saveOrUpdateHotPriceOrder(hotPriceOrder);
		System.out.println(hotPriceOrder);
		return "redirect:hot-price-schedule-list";
	}

	@RequestMapping("/hot-price-order/{id}")
	public String processHotPriceOrder(Model model, @PathVariable(value = "id") Long id) {
		HotPriceOrder hotPriceOrder = hotPriceOrderService.findByid(id);
		LocalDate hotPriceSchedule = hotPriceOrder.getHotPriceSchedule().getHotPriceStartDate();
		model.addAttribute("hotPriceOrder", hotPriceOrder);
		model.addAttribute("hotPriceSchedule", hotPriceSchedule);
		return "hot-price-order";
	}

}
