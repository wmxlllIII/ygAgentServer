package com.dmy.ygagentserver.module.repository;

import com.dmy.ygagentserver.module.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {

    User findById(@Param("userId")long userId);

    @Insert("insert into users(user_id, nickname, avatar_url) values(#{userId}, #{nickname}, #{avatarUrl})")
    void insertUser(User user);

}

