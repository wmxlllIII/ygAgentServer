package com.dmy.ygagentserver.module.service.impl;

import com.dmy.ygagentserver.common.result.ApiResponse;
import com.dmy.ygagentserver.module.dto.req.PubOrderReqDTO;
import com.dmy.ygagentserver.module.dto.resp.PubOrderRespDTO;
import com.dmy.ygagentserver.module.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public ApiResponse<PubOrderRespDTO> publishOrder(PubOrderReqDTO reqDTO) {
        return null;
    }
}
