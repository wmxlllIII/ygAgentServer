package com.dmy.ygagentserver.module.repository;

import com.dmy.ygagentserver.module.entity.Campus;
import com.dmy.ygagentserver.module.entity.School;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SchoolRepository {

    List<School> findSchoolByKey(@Param("key") String s);

    int updateBindSchool(@Param("userId") long userId, @Param("schoolId") int schoolId, @Param("campusId") int campusId);

    School findSchoolById(@Param("schoolId") int schoolId);

    Campus findCampusById(@Param("campusId") int campusId);

    @Select("select * from campus where school_id = #{schoolId}")
    List<Campus> selectCampusesBySchoolId(@Param("schoolId")int schoolId);
}
