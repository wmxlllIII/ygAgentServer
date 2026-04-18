package com.dmy.ygagentserver.module.user.service;

import com.dmy.ygagentserver.module.user.dto.req.LoginReqDTO;
import com.dmy.ygagentserver.module.user.dto.resp.LoginRespDTO;

public interface UserService {
    LoginRespDTO login(LoginReqDTO req);
}
