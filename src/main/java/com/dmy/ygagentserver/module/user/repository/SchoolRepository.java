package com.dmy.ygagentserver.module.user.repository;

import com.dmy.ygagentserver.module.user.entity.Campus;
import com.dmy.ygagentserver.module.user.entity.School;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SchoolRepository {

    List<School> findSchoolByKey(@Param("key") String s);

    int updateBindSchool(@Param("userId") long userId, @Param("schoolId") int schoolId, @Param("campusId") int campusId);

    School findSchoolById(@Param("schoolId") int schoolId);

    Campus findCampusById(@Param("campusId") int campusId);
}
