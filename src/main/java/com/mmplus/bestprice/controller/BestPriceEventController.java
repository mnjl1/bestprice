package com.mmplus.bestprice.controller;

import com.mmplus.bestprice.entity.BestPriceEvent;
import com.mmplus.bestprice.service.BestPriceEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/best-price")
public class BestPriceEventController {

    @Autowired
    private BestPriceEventService bestPriceEventService;

    @RequestMapping(value = "/create-best-price-event-form")
    public String saveBestPriceEvent(Model model){
        BestPriceEvent bestPriceEvent = new BestPriceEvent();
        model.addAttribute("bestPriceEvent", bestPriceEvent);
        return  "best-price-event-form";
    }

    @RequestMapping("/processSaveBestPriceEvent")
    public String processSaveBestPriceEvent(Model model, BestPriceEvent bestPriceEvent){
        model.addAttribute("bestPriceEvent", bestPriceEvent);
        bestPriceEventService.saveOrUpdateBestPriceEvent(bestPriceEvent);
        return "redirect:best-price-event-list";
    }

    @RequestMapping("/best-price-event-list")
    public String getBestPriceEventsList(Model model){
        model.addAttribute("bestPriceEvents", bestPriceEventService.findAll());
        return "best-price-event-list";
    }
}
