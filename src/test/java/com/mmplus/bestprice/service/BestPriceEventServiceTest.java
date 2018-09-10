package com.mmplus.bestprice.service;

import com.mmplus.bestprice.entity.BestPriceEvent;
import com.mmplus.bestprice.repository.BestPriceEventRepository;
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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BestPriceEventServiceTest {

    @Mock
    private BestPriceEventRepository bestPriceEventRepository;

    private BestPriceEventService bestPriceEventService;

    private BestPriceEvent bestPriceEvent;
    private BestPriceEvent bestPriceEvent2;

    @Before
    public void setup(){
        bestPriceEventService = new BestPriceEventServiceImpl(bestPriceEventRepository);
        bestPriceEvent = new BestPriceEvent(1L, LocalDate.of(2018, 9, 1)
                , LocalDate.of(2018, 9, 14));
        bestPriceEvent2 = new BestPriceEvent(2L, LocalDate.of(2018, 9, 15)
                , LocalDate.of(2018, 9, 29));
    }

    @Test
    public void saveBestPriceEventTest(){
        Mockito.when(bestPriceEventRepository.save(bestPriceEvent))
                .thenReturn(bestPriceEvent);

        BestPriceEvent actualEvent = bestPriceEventService.saveOrUpdateBestPriceEvent(bestPriceEvent);

        assertThat(actualEvent).isNotNull().isEqualTo(bestPriceEvent)
                    .isEqualToComparingFieldByField(bestPriceEvent);
    }

    @Test
    public void findBestPriceEventByIdTest(){

        Mockito.when(bestPriceEventRepository.getOne(1L))
                .thenReturn(bestPriceEvent);

        BestPriceEvent event = bestPriceEventService.findBestPriceEventById(1L);

        assertThat(event).isNotNull()
                .isEqualTo(bestPriceEvent)
                .isEqualToComparingFieldByField(bestPriceEvent);
    }

    @Test
    public void findAllEventsTest(){
        List<BestPriceEvent> events = Arrays.asList(bestPriceEvent, bestPriceEvent2);
        Mockito.when(bestPriceEventRepository.findAll())
                .thenReturn(events);
        List<BestPriceEvent> actualList = bestPriceEventService.findAll();

        assertThat(events).isNotNull()
            .isEqualToComparingFieldByField(actualList);
    }
}