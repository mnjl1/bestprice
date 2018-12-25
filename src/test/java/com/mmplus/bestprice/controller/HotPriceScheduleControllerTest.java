package com.mmplus.bestprice.controller;

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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HotPriceScheduleControllerTest {
	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private HotPriceScheduleService hotPriceScheduleService;
	private HotPriceScheduleController controller;
	private MockMvc mockMvc;
	private final LocalDate hotPriceStartDate = LocalDate.of(2018, 11, 01);
	
	@Before
	public void setup() {
		controller = new HotPriceScheduleController(hotPriceScheduleService);
		
		mockMvc = MockMvcBuilders
				.webAppContextSetup(wac)
				.build();
	}
	
	@Test
	public void shouldReturnHotPriceForm_whenFormRequest() throws Exception {
			mockMvc.perform(get("/mmplus/hot-price-schedule-form"))
				.andExpect(status().isOk())
				.andExpect(view().name("hot-price-schedule-form"));
	}
	
	@Test
	public void shouldReturnScheduleList_whenRequest() throws Exception {
		mockMvc.perform(get("/company/hot-price-schedule-list"))
			.andExpect(status().isOk())
			.andExpect(view().name("hot-price-schedule-list"))
			.andExpect(model().attributeExists("hotPriceEvents"));
	}
}
