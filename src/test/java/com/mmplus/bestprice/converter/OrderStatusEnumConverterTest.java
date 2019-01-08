package com.mmplus.bestprice.converter;

import com.mmplus.bestprice.entity.OrderStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Locale;

import static com.mmplus.bestprice.util.Constants.UA_ORDER_STATUS_ACCEPTED;
import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderStatusEnumConverterTest {
    @Autowired
    private OrderStatusEnumFormatter orderStatusEnumFormatter;

    @Test
    public void shouldReturnOrderStatus_whenParse() throws ParseException {
        OrderStatus expectedStatus = OrderStatus.ORDER_STATUS_ACCEPTED;

        Locale locale = new Locale("uk");

        OrderStatus actualStatus = orderStatusEnumFormatter.parse(UA_ORDER_STATUS_ACCEPTED, locale);

        assertThat(actualStatus)
                .isNotNull()
                .isEqualTo(expectedStatus);
    }

    @Test
    public void shouldReturnOrderStatusLevel_whenPrint(){
        OrderStatus status = OrderStatus.ORDER_STATUS_ACCEPTED;

        Locale locale = new Locale("uk");

        String actual = orderStatusEnumFormatter.print(status, locale);

        assertThat(actual)
                .isNotNull()
                .isEqualTo(UA_ORDER_STATUS_ACCEPTED);
    }
}
