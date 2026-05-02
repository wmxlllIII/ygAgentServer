package com.dmy.ygagentserver.module.controller;

import com.dmy.ygagentserver.common.result.ApiResponse;
import com.dmy.ygagentserver.module.dto.req.PubOrderReqDTO;
import com.dmy.ygagentserver.module.dto.resp.PubOrderRespDTO;
import com.dmy.ygagentserver.module.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/publish")
    public ApiResponse<PubOrderRespDTO> publishOrder(@RequestBody PubOrderReqDTO reqDTO) {
        return orderService.publishOrder(reqDTO);
    }
}
