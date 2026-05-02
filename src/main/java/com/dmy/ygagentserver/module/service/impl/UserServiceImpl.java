package com.dmy.ygagentserver.module.service.impl;

import com.dmy.ygagentserver.common.enums.LoginType;
import com.dmy.ygagentserver.common.result.ApiResponse;
import com.dmy.ygagentserver.common.result.ResultCode;
import com.dmy.ygagentserver.common.util.JwtUtil;
import com.dmy.ygagentserver.common.util.PasswordUtil;
import com.dmy.ygagentserver.config.BaseContext;
import com.dmy.ygagentserver.module.dto.req.LoginReqDTO;
import com.dmy.ygagentserver.module.dto.req.RegisterReqDTO;
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
    public ApiResponse<LoginRespDTO> login(LoginReqDTO req) {
        LoginType loginType = req.getLoginType();
        log.info(TAG + ": login, loginType: " + loginType);
        switch (loginType) {
            case PASSWORD:
                return passwordLogin(req);
            case MAIL:
                return mailLogin(req);
            default:
                return ApiResponse.error(ResultCode.UNSUPPORTED_LOGIN_TYPE.code(), ResultCode.UNSUPPORTED_LOGIN_TYPE.msg());
        }
    }

    @Override
    public ApiResponse<Boolean> register(RegisterReqDTO req) {
        String phone = req.getPhone();
        String password = req.getPassword();

        Auth existAuth = authRepository.findByTypeAndAccount(LoginType.PASSWORD.getCode(), phone);
        if (existAuth != null) {
            return ApiResponse.error(ResultCode.PHONE_ALREADY_REGISTERED.code(), ResultCode.PHONE_ALREADY_REGISTERED.msg());
        }

        User user = new User();
        user.setUserId(System.currentTimeMillis());
        user.setNickname("用户" + phone.substring(7));
        user.setAvatarUrl("");
        user.setRating(0.0);
        user.setGender(0);
        user.setTotalOrders(0);
        user.setStatus(1);

        userRepository.insertUser(user);

        String encodedPassword = PasswordUtil.encode(password);

        Auth auth = new Auth();
        auth.setUserId(user.getUserId());
        auth.setLoginType(LoginType.PASSWORD.getCode());
        auth.setAccount(phone);
        auth.setPassword(encodedPassword);
        auth.setStatus(1);

        authRepository.insertAuth(auth);

        log.info(TAG + ": register success, userId: " + user.getUserId());
        return ApiResponse.success(true);
    }

    @Override
    public ApiResponse<LoginRespDTO> autoLogin() {
        long userId = BaseContext.getCurrentId();
        log.info(TAG + ": autoLogin, userId: " + userId);

        User user = userRepository.findById(userId);
        if (user == null) {
            return ApiResponse.error(ResultCode.USER_NOT_EXIST.code(), ResultCode.USER_NOT_EXIST.msg());
        }

        String token = JwtUtil.generateToken(user);

        return ApiResponse.success(new LoginRespDTO(
                user.getUserId(),
                user.getNickname(),
                user.getAvatarUrl(),
                token
        ));
    }

    private ApiResponse<LoginRespDTO> passwordLogin(LoginReqDTO req) {
        log.info(TAG + ": passwordLogin, req: " + req + "==" + LoginType.PASSWORD.getCode());
        Auth auth = authRepository.findByTypeAndAccount(
                LoginType.PASSWORD.getCode(),
                req.getAccount()
        );

        log.info(TAG + ": passwordLogin, login: " + auth);
        if (auth == null) {
            return ApiResponse.error(ResultCode.USER_NOT_EXIST.code(), ResultCode.USER_NOT_EXIST.msg());
        }

//        if (!PasswordUtil.matches(req.getPassword(), login.getPassword())) {
//            throw new BusinessException(ResultCode.PASSWORD_ERROR);
//        }
        User user = userRepository.findById(auth.getUserId());

        log.info(TAG + ": passwordLogin, user: " + user);
        String token = JwtUtil.generateToken(user);

        return ApiResponse.success(new LoginRespDTO(
                user.getUserId(),
                user.getNickname(),
                user.getAvatarUrl(),
                token
        ));
    }

    private ApiResponse<LoginRespDTO> mailLogin(LoginReqDTO req) {
        Auth auth = authRepository.findByTypeAndAccount(
                LoginType.MAIL.getCode(),
                req.getAccount()
        );

        if (auth == null) {
            return ApiResponse.error(ResultCode.USER_NOT_EXIST.code(), ResultCode.USER_NOT_EXIST.msg());
        }

        User user = userRepository.findById(auth.getUserId());

        String token = JwtUtil.generateToken(user);

        return ApiResponse.success(new LoginRespDTO(
                user.getUserId(),
                user.getNickname(),
                user.getAvatarUrl(),
                token
        ));
    }

}

