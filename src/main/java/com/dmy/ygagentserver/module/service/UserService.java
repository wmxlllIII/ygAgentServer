package com.dmy.ygagentserver.module.service;

import com.dmy.ygagentserver.common.result.ApiResponse;
import com.dmy.ygagentserver.module.dto.req.LoginReqDTO;
import com.dmy.ygagentserver.module.dto.req.RegisterReqDTO;
import com.dmy.ygagentserver.module.dto.resp.LoginRespDTO;

public interface UserService {
    ApiResponse<LoginRespDTO> login(LoginReqDTO req);

    ApiResponse<Boolean> register(RegisterReqDTO req);

    ApiResponse<LoginRespDTO> autoLogin();

}
