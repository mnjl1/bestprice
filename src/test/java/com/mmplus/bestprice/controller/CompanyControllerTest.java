package com.mmplus.bestprice.controller;

import com.mmplus.bestprice.entity.HotPriceOrder;
import com.mmplus.bestprice.entity.HotPriceSchedule;
import com.mmplus.bestprice.service.HotPriceOrderService;
import com.mmplus.bestprice.service.HotPriceScheduleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private HotPriceOrderService hotPriceOrderService;
    @Autowired
    private HotPriceScheduleService hotPriceScheduleService;
    private HotPriceOrderController hotPriceOrderController;
    private MockMvc mockMvc;
    private HotPriceSchedule hotPriceSchedule;
    private HotPriceOrder hotPriceOrder;

    @Before
    public void setup(){
        hotPriceOrderController = new HotPriceOrderController(hotPriceOrderService);

        hotPriceSchedule = new HotPriceSchedule();
        hotPriceSchedule = new HotPriceSchedule(1L, LocalDate.of(2018, 9, 1)
                , LocalDate.of(2018, 9, 14));
        hotPriceScheduleService.saveOrUpdateBestPriceEvent(hotPriceSchedule);

        hotPriceOrder = new HotPriceOrder();
        hotPriceOrder.setCompanyName("Ferrero");
        hotPriceOrder.setCreatedAt(LocalDate.now());
        hotPriceOrderService.saveOrUpdateHotPriceOrder(hotPriceOrder);

        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void shouldReturnScheduleList() throws Exception {
        mockMvc.perform(get("/company/hot-price-schedule-list"))
                .andExpect(status().isOk())
                .andExpect(view().name("hot-price-schedule-list"));
    }

    @Test
    public void shouldRedirectToOrderForm_whenSaveOrUpdate() throws Exception {
        mockMvc.perform(get("/company/create-hot-price-order-form/"
                +hotPriceSchedule.getId()))
                .andExpect(status().isOk());
    }

    //todo fix test: call on null object
//    @Test
//    public void shouldReturnHotPriceOrderForm() throws Exception {
//
//        mockMvc.perform(get("/company/hot-price-order-form"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("hot-price-order-form"));
//    }

    @Test
    public void shouldRedirectToScheduleList_whenSavedForm() throws Exception {
        mockMvc.perform(post("/company/process-hot-price-order-form"))
                .andExpect(redirectedUrl("/hot-price-schedule-list"));
    }
}
