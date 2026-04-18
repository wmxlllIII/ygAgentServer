package com.dmy.ygagentserver.module.user.controller;

import com.dmy.ygagentserver.common.result.ApiResponse;
import com.dmy.ygagentserver.module.user.dto.req.LoginReqDTO;
import com.dmy.ygagentserver.module.user.dto.resp.LoginRespDTO;
import com.dmy.ygagentserver.module.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation("登录")
    public ApiResponse<LoginRespDTO> login(@RequestBody LoginReqDTO req) {
        return ApiResponse.success(userService.login(req));
    }
}
