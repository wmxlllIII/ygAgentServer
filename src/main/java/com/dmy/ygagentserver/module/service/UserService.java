package com.dmy.ygagentserver.module.service;

import com.dmy.ygagentserver.module.dto.req.LoginReqDTO;
import com.dmy.ygagentserver.module.dto.resp.LoginRespDTO;

public interface UserService {
    LoginRespDTO login(LoginReqDTO req);
}
