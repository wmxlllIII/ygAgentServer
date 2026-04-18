package com.dmy.ygagentserver.module.user.controller;

import com.dmy.ygagentserver.module.user.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @RequestMapping("/publish")
}
