package com.mmplus.bestprice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mmplus.bestprice.entity.BestPriceEvent;
import com.mmplus.bestprice.entity.HotPriceOrder;
import com.mmplus.bestprice.service.BestPriceEventService;
import com.mmplus.bestprice.service.HotPriceOrderService;

@Controller
public class HotPriceOrderController {
	
	private HotPriceOrderService hotPriceOrderService;
	private BestPriceEventService bestPriceEventService;
	
	public HotPriceOrderController(HotPriceOrderService hotPriceOrderService,
			BestPriceEventService bestPriceEventService) {
		this.hotPriceOrderService = hotPriceOrderService;
		this.bestPriceEventService = bestPriceEventService;
	}

	@RequestMapping(value="/create-best-price-order-form/{id}", method=RequestMethod.GET)
	public String saveOrUpdateOrder(Model model, @PathVariable(value="id") Long id) {
		HotPriceOrder hotPriceOrder = new HotPriceOrder();
		BestPriceEvent bestPriceEvent = bestPriceEventService.findById(id);
		model.addAttribute("hotPriceOrder", hotPriceOrder);
		model.addAttribute("bestPriceEvent", bestPriceEvent);
		
		//test
		System.out.println(bestPriceEvent);
		return "redirect:hot-price-order-form";
	}
	
	@RequestMapping("/hot-price-order-form")
	public String hotPriceOrderForm(Model model, HotPriceOrder hotPriceOrder) {
		model.addAttribute("hotPriceOrder", hotPriceOrder);
		System.out.println("inside form " +hotPriceOrder);
		return "hot-price-order-form";
	}
	
	@RequestMapping("/process-hot-price-order-form")
	public String processHotPriceForm(Model model, HotPriceOrder hotPriceOrder){
		model.addAttribute("hotPriceOrder", hotPriceOrder);
		hotPriceOrderService.saveOrUpdateHotPriceOrder(hotPriceOrder);
		
		//test
		System.out.println("inside process " +hotPriceOrder);
		return "redirect:best-price-event-list";
	}
}
