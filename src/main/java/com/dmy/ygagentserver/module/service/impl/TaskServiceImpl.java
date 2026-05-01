package com.dmy.ygagentserver.module.service.impl;

import com.dmy.ygagentserver.common.result.ApiResponse;
import com.dmy.ygagentserver.common.result.ResultCode;
import com.dmy.ygagentserver.module.dto.req.TaskPubReqDTO;
import com.dmy.ygagentserver.module.dto.resp.TaskPubRespDTO;
import com.dmy.ygagentserver.module.repository.TaskRepository;
import com.dmy.ygagentserver.module.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public ApiResponse<TaskPubRespDTO> publish(TaskPubReqDTO req) {
        return ApiResponse.error(ResultCode.TODO.code(), ResultCode.TODO.msg());
    }
}
