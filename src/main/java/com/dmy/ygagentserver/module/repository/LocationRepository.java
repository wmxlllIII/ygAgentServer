package com.dmy.ygagentserver.module.repository;

import com.dmy.ygagentserver.module.entity.Location;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LocationRepository {
    List<Location> findLocationsByCampusId(@Param("campusId")int campusId);
}
