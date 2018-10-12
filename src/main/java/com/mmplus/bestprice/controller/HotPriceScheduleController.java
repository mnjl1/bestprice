package com.mmplus.bestprice.controller;

import com.mmplus.bestprice.entity.HotPriceSchedule;
import com.mmplus.bestprice.service.HotPriceScheduleService;

import ch.qos.logback.core.net.SyslogOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotPriceScheduleController {

	@Autowired
    private HotPriceScheduleService hotPriceScheduleService;

    @RequestMapping(value = "/hot-price-schedule-form")
    public String saveHotPriceSchedule(Model model){
        HotPriceSchedule hotPriceSchedule = new HotPriceSchedule();
        model.addAttribute("hotPriceSchedule", hotPriceSchedule);
        return  "hot-price-schedule-form";
    }

    @RequestMapping("/processSaveHotPriceSchedule")
    public String processSaveHotPriceSchedule(Model model, HotPriceSchedule hotPriceSchedule){
        model.addAttribute("hotPriceSchedule", hotPriceSchedule);
        hotPriceScheduleService.saveOrUpdateHotPriceSchedule(hotPriceSchedule);
        
        System.out.println(hotPriceSchedule);
        return "redirect:/hot-price-schedule-list";
    }

    @RequestMapping("/hot-price-schedule-list")
    public String getHotPriceScheduleList(Model model){
    	System.out.println("in list");
        model.addAttribute("hotPriceEvents", hotPriceScheduleService.findAll());
        
        return "hot-price-schedule-list";
    }
}
