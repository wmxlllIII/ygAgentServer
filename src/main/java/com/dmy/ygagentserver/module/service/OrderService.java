package com.dmy.ygagentserver.module.service;

import com.dmy.ygagentserver.common.result.ApiResponse;
import com.dmy.ygagentserver.module.dto.req.PubOrderReqDTO;
import com.dmy.ygagentserver.module.dto.resp.PubOrderRespDTO;

public interface OrderService {
    ApiResponse<PubOrderRespDTO> publishOrder(PubOrderReqDTO reqDTO);
}
