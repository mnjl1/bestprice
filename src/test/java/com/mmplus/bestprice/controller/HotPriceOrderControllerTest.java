package com.mmplus.bestprice.controller;

import com.mmplus.bestprice.entity.HotPriceOrder;
import com.mmplus.bestprice.entity.HotPriceSchedule;
import com.mmplus.bestprice.entity.OrderStatus;
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
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HotPriceOrderControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private HotPriceOrderService hotPriceOrderService;
    @Autowired
    private HotPriceScheduleService hotPriceScheduleService;

    private HotPriceOrderController hotPriceOrderController;
    private HotPriceScheduleController hotPriceScheduleController;
    private HotPriceSchedule hotPriceSchedule;
    private HotPriceOrder hotPriceOrder;
    private OrderStatus orderStatus;
    private ArrayList<HotPriceOrder> orders;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        hotPriceOrderController = new HotPriceOrderController(hotPriceOrderService);
        hotPriceScheduleController = new HotPriceScheduleController(hotPriceScheduleService);

        hotPriceOrder = new HotPriceOrder();
        hotPriceOrder.setId(1L);
        hotPriceOrder.setCreatedAt(LocalDate.now());
        hotPriceOrder.setCompanyName("Ferrero");
        hotPriceOrder.setDiscountPrice(5L);
        hotPriceOrder.setRegularPrice(6L);
        hotPriceOrder.setOrderStatus(orderStatus);
        hotPriceOrder.setProductEan("12345");
        hotPriceOrderService.saveOrUpdateHotPriceOrder(hotPriceOrder);

        //todo fix
        //orders.add(hotPriceOrder);

        hotPriceSchedule = new HotPriceSchedule();
        hotPriceSchedule.setHotPriceStartDate(LocalDate.now());
        hotPriceSchedule.setHotPriceEndDate(LocalDate.now());

        hotPriceScheduleService.saveOrUpdateBestPriceEvent(hotPriceSchedule);



        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }



    //todo fix test
    @Test
    public void shouldReturnHottPriceOrderTemplate_whenProcessOrderById() throws Exception {
//        mockMvc.perform(get("/mmplus/hot-price-order/"
//                +hotPriceSchedule.getId()))
//                .andExpect(status().isOk())
//                .andExpect(view().name("hot-price-order"));
        }
}
