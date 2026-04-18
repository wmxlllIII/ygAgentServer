package com.dmy.ygagentserver.module.user.repository;

import com.dmy.ygagentserver.module.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {

    User findById(@Param("userId")long userId);
}

