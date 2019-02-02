package com.mmplus.bestprice.converter;

import com.mmplus.bestprice.entity.OrderStatus;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;

@Service
public class OrderStatusEnumFormatter implements Formatter<OrderStatus> {

    @Override
    public OrderStatus parse(final String s, final Locale locale) throws ParseException {
        return Arrays.stream(OrderStatus.values())
                .filter(orderStatus -> orderStatus.toString().equals(s))
                .findAny().orElse(OrderStatus.ORDER_STATUS_UNDER_CONSIDERATION);
    }

    @Override
    public String print(final OrderStatus orderStatus, final Locale locale) {
        return orderStatus.toString();
    }

}
