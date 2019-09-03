package com.jay.spring.cloud.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * created by Jay on 2019/9/3
 */
@RestController
public class OrderController
{
    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    @GetMapping("/order/book")
    public String orderBook()
    {
        return "order:book:" + restTemplate.getForObject("http://pay-service/pay/book", String.class);
    }
}
