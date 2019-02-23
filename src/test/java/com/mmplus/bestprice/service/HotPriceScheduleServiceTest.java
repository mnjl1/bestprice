package com.mmplus.bestprice.service;

import com.mmplus.bestprice.entity.HotPriceSchedule;
import com.mmplus.bestprice.repository.HotPriceScheduleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotPriceScheduleServiceTest {

    @Mock
    private HotPriceScheduleRepository hotPriceScheduleRepository;

    private HotPriceScheduleService hotPriceScheduleService;

    private HotPriceSchedule hotPriceSchedule;
    private HotPriceSchedule hotPriceSchedule2;

    @Before
    public void setup(){
        hotPriceScheduleService = new HotPriceScheduleServiceImpl(hotPriceScheduleRepository);
        hotPriceSchedule = new HotPriceSchedule(1L, LocalDate.of(2018, 9, 1)
                , LocalDate.of(2018, 9, 14));
        hotPriceSchedule2 = new HotPriceSchedule(2L, LocalDate.of(2018, 9, 15)
                , LocalDate.of(2018, 9, 29));
    }

    @Test
    public void saveBestPriceEventTest(){
        Mockito.when(hotPriceScheduleRepository.save(hotPriceSchedule))
                .thenReturn(hotPriceSchedule);

        HotPriceSchedule actualEvent = hotPriceScheduleService.saveOrUpdateBestPriceEvent(hotPriceSchedule);

        assertThat(actualEvent).isNotNull().isEqualTo(hotPriceSchedule)
                    .isEqualToComparingFieldByField(hotPriceSchedule);
    }

    @Test
    public void findBestPriceEventByIdTest(){

        Mockito.when(hotPriceScheduleRepository.findById(1L))
                .thenReturn(Optional.ofNullable(hotPriceSchedule));

        Optional<HotPriceSchedule> event = hotPriceScheduleRepository.findById(1L);

        assertThat(event).get().isNotNull()
                .isEqualTo(hotPriceSchedule);
    }

    @Test
    public void findAllEventsTest(){
        List<HotPriceSchedule> events = Arrays.asList(hotPriceSchedule, hotPriceSchedule2);
        Mockito.when(hotPriceScheduleRepository.findAll())
                .thenReturn(events);
        List<HotPriceSchedule> actualList = hotPriceScheduleService.findAll();

        assertThat(events).isNotNull()
            .isEqualToComparingFieldByField(actualList);
    }
}