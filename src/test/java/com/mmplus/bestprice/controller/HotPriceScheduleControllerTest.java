package com.mmplus.bestprice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.beans.HasProperty;
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

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.mmplus.bestprice.entity.HotPriceSchedule;
import com.mmplus.bestprice.service.HotPriceScheduleService;

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
	
//	private HotPriceSchedule hotPriceSchedule1;
//	private HotPriceSchedule hotPriceSchedule2;
//	private List<HotPriceSchedule> hotPriceEvents;
	
	@Before
	public void setup() {
		controller = new HotPriceScheduleController(hotPriceScheduleService);
		
		mockMvc = MockMvcBuilders
				.webAppContextSetup(wac)
				.build();
		
//		hotPriceSchedule1 = new HotPriceSchedule();
//		hotPriceSchedule2 = new HotPriceSchedule();
//		
//		hotPriceSchedule1.setHotPriceStartDate(LocalDate.of(2018, 11, 01));
//		hotPriceSchedule1.setHotPriceEndDate(LocalDate.of(2018, 11, 15));
//		hotPriceSchedule2.setHotPriceEndDate(LocalDate.of(2018, 11, 16));
//		hotPriceSchedule2.setHotPriceEndDate(LocalDate.of(2018, 11, 30));
//		
//		hotPriceEvents.add(hotPriceSchedule1);
//		hotPriceEvents.add(hotPriceSchedule2);
	}
	
	@Test
	public void shoulReturnHotPriceForm_whenFormRequest() throws Exception {
			mockMvc.perform(get("/hot-price-schedule-form"))
				.andExpect(status().isOk())
				.andExpect(view().name("hot-price-schedule-form"));
	}
	
	@Test
	public void shouldReturnSheduleList_whenRequest() throws Exception {
		mockMvc.perform(get("/hot-price-schedule-list"))
			.andExpect(status().isOk())
			.andExpect(view().name("hot-price-schedule-list"))
			.andExpect(model().attributeExists("hotPriceEvents"));
//			.andExpect(model().attribute("hot-price-schedule-list", Matchers.hasItem(Matchers
//					.<HotPriceSchedule> hasProperty("hotPriceStartDate",
//							Matchers.equalTo(hotPriceStartDate)))));
	}
}
