package com.dmy.ygagentserver.module.service;

import com.dmy.ygagentserver.common.result.ApiResponse;
import com.dmy.ygagentserver.module.dto.req.TaskPubReqDTO;
import com.dmy.ygagentserver.module.dto.resp.TaskPubRespDTO;

public interface TaskService {

    ApiResponse<TaskPubRespDTO> publish(TaskPubReqDTO req);
}
