package com.dmy.ygagentserver.module.service.impl;

import com.dmy.ygagentserver.common.enums.LoginType;
import com.dmy.ygagentserver.common.exception.BusinessException;
import com.dmy.ygagentserver.common.result.ResultCode;
import com.dmy.ygagentserver.common.util.JwtUtil;
import com.dmy.ygagentserver.module.dto.req.LoginReqDTO;
import com.dmy.ygagentserver.module.dto.resp.LoginRespDTO;
import com.dmy.ygagentserver.module.entity.Auth;
import com.dmy.ygagentserver.module.entity.User;
import com.dmy.ygagentserver.module.repository.AuthRepository;
import com.dmy.ygagentserver.module.repository.UserRepository;
import com.dmy.ygagentserver.module.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public static final String TAG = "YG_UserServiceImpl";
    private static final Log log = LogFactory.getLog(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthRepository authRepository;

    @Override
    public LoginRespDTO login(LoginReqDTO req) {
        LoginType loginType = req.getLoginType();
        log.info(TAG + ": login, loginType: " + loginType);
        switch (loginType) {
            case PASSWORD:
                return passwordLogin(req);
            case MAIL:
                return mailLogin(req);
            default:
                throw new BusinessException(ResultCode.UNSUPPORTED_LOGIN_TYPE);
        }
    }

    private LoginRespDTO passwordLogin(LoginReqDTO req) {
        log.info(TAG + ": passwordLogin, req: " + req + "==" + LoginType.PASSWORD.getCode());
        Auth auth = authRepository.findByTypeAndAccount(
                LoginType.PASSWORD.getCode(),
                req.getAccount()
        );

        log.info(TAG + ": passwordLogin, login: " + auth);
        if (auth == null) {
            log.info(TAG + "login:空了 ");
            throw new BusinessException(ResultCode.USER_NOT_EXIST);
        }

//        if (!PasswordUtil.matches(req.getPassword(), login.getPassword())) {
//            throw new BusinessException(ResultCode.PASSWORD_ERROR);
//        }
        log.info(TAG + "login:没空 ");
        User user = userRepository.findById(auth.getUserId());

        log.info(TAG + ": passwordLogin, user: " + user);
        String token = JwtUtil.generateToken(user);

        return new LoginRespDTO(
                user.getUserId(),
                user.getNickname(),
                token
        );
    }

    private LoginRespDTO mailLogin(LoginReqDTO req) {
        Auth auth = authRepository.findByTypeAndAccount(
                LoginType.MAIL.getCode(),
                req.getAccount()
        );

        if (auth == null) {
            throw new BusinessException(ResultCode.USER_NOT_EXIST);
        }

        User user = userRepository.findById(auth.getUserId());

        String token = JwtUtil.generateToken(user);

        return new LoginRespDTO(
                user.getId(),
                user.getNickname(),
                token
        );
    }

}

