package com.mmplus.bestprice.config;

import com.mmplus.bestprice.converter.OrderStatusEnumFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private OrderStatusEnumFormatter orderStatusEnumFormatter;

    public void addFormatter(FormatterRegistry formatterRegistry){
        formatterRegistry.addFormatter(orderStatusEnumFormatter);
    }
}
