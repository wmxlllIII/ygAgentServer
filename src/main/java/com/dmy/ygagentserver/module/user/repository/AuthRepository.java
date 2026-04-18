package com.dmy.ygagentserver.module.user.repository;

import com.dmy.ygagentserver.module.user.entity.Auth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthRepository {

    Auth findByTypeAndAccount(@Param("loginType") int code, @Param("account") String account);
}
