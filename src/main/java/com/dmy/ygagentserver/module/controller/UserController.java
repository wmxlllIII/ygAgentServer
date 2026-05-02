package com.dmy.ygagentserver.module.controller;

import com.dmy.ygagentserver.common.result.ApiResponse;
import com.dmy.ygagentserver.module.dto.req.LoginReqDTO;
import com.dmy.ygagentserver.module.dto.req.RegisterReqDTO;
import com.dmy.ygagentserver.module.dto.resp.LoginRespDTO;
import com.dmy.ygagentserver.module.service.UserService;
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
        return userService.login(req);
    }

    @PostMapping("/register")
    @ApiOperation("注册")
    public ApiResponse<Boolean> register(@RequestBody RegisterReqDTO req) {
        return userService.register(req);
    }

    @PostMapping("/autoLogin")
    @ApiOperation("自动登录")
    public ApiResponse<LoginRespDTO> autoLogin() {
        return userService.autoLogin();
    }
}
