package com.mmplus.bestprice.controller;

import com.mmplus.bestprice.entity.HotPriceSchedule;
import com.mmplus.bestprice.service.HotPriceScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotPriceScheduleController {

    private HotPriceScheduleService hotPriceScheduleService;
    
    public HotPriceScheduleController(HotPriceScheduleService hotPriceScheduleService) {
		super();
		this.hotPriceScheduleService = hotPriceScheduleService;
	}

    @RequestMapping(value = "/hot-price-schedule-form")
    public String saveBestPriceEvent(Model model){
        HotPriceSchedule hotPriceSchedule = new HotPriceSchedule();
        model.addAttribute("hotPriceSchedule", hotPriceSchedule);
        return "hot-price-schedule-form";
    }

    @RequestMapping("/processSaveHotPriceSchedule")
    public String processSaveBestPriceEvent(Model model, HotPriceSchedule hotPriceSchedule){
        model.addAttribute("hotPriceSchedule", hotPriceSchedule);
        hotPriceScheduleService.saveOrUpdateBestPriceEvent(hotPriceSchedule);
        return "redirect:hot-price-schedule-list";
    }

    @RequestMapping("/hot-price-schedule-list")
    public String getBestPriceEventsList(Model model){
        model.addAttribute("hotPriceEvents", hotPriceScheduleService.findAll());
        return "hot-price-schedule-list";
    }
    
}
