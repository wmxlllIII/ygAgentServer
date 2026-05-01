package com.dmy.ygagentserver.module.controller;

import com.dmy.ygagentserver.common.result.ApiResponse;
import com.dmy.ygagentserver.module.dto.req.TaskPubReqDTO;
import com.dmy.ygagentserver.module.dto.resp.TaskPubRespDTO;
import com.dmy.ygagentserver.module.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/publish")
    public ApiResponse<TaskPubRespDTO> publish(@RequestBody TaskPubReqDTO req) {
        return taskService.publish(req);
    }
}
