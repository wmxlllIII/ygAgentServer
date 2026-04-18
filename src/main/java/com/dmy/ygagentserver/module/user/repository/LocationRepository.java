package com.dmy.ygagentserver.module.user.repository;

import com.dmy.ygagentserver.module.user.entity.Location;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LocationRepository {
    List<Location> findLocationsByCampusId(@Param("campusId")int campusId);
}
