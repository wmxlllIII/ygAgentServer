package com.dmy.ygagentserver.module.service.impl;

import com.dmy.ygagentserver.common.result.ApiResponse;
import com.dmy.ygagentserver.common.result.ResultCode;
import com.dmy.ygagentserver.config.BaseContext;
import com.dmy.ygagentserver.module.dto.req.BindSchoolReqDTO;
import com.dmy.ygagentserver.module.dto.req.GetLocationReqDTO;
import com.dmy.ygagentserver.module.dto.req.SearchSchoolReqDTO;
import com.dmy.ygagentserver.module.dto.resp.BindSchoolRespDTO;
import com.dmy.ygagentserver.module.dto.resp.GetLocationRespDTO;
import com.dmy.ygagentserver.module.dto.resp.SearchSchoolRespDTO;
import com.dmy.ygagentserver.module.entity.Campus;
import com.dmy.ygagentserver.module.entity.Location;
import com.dmy.ygagentserver.module.entity.School;
import com.dmy.ygagentserver.module.repository.LocationRepository;
import com.dmy.ygagentserver.module.repository.SchoolRepository;
import com.dmy.ygagentserver.module.service.SchoolService;
import com.dmy.ygagentserver.module.vo.SchoolVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolServiceImpl implements SchoolService {
    public static final String TAG = "YG_SchoolServiceImpl";
    private static final Log log = LogFactory.getLog(SchoolServiceImpl.class);

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public ApiResponse<SearchSchoolRespDTO> searchSchool(SearchSchoolReqDTO req) {
        // 1. 查询学校列表
        List<School> schools = schoolRepository.findSchoolByKey(req.getKeyword());

        List<SchoolVO> schoolVOList = new ArrayList<>();

        // 2. 遍历学校 + 遍历校区，一个校区生成一条 VO
        for (School school : schools) {
            // 查询该学校下所有校区
            List<Campus> campuses = schoolRepository.selectCampusesBySchoolId(school.getId());

            if (campuses == null || campuses.isEmpty()) {
                // 没有校区也保留一条学校数据
                SchoolVO vo = new SchoolVO();
                vo.setId(school.getId());
                vo.setSchoolId(school.getId());
                vo.setSchoolName(school.getName());
                vo.setProvince(school.getProvince());
                vo.setCity(school.getCity());
                schoolVOList.add(vo);
            } else {
                // 有几个校区，就生成几条 VO
                for (Campus campus : campuses) {
                    SchoolVO vo = new SchoolVO();
                    vo.setId(school.getId());
                    vo.setSchoolId(school.getId());
                    vo.setSchoolName(school.getName());
                    vo.setProvince(school.getProvince());
                    vo.setCity(school.getCity());

                    // 每个校区单独赋值
                    vo.setCampusId(campus.getId());
                    vo.setCampusName(campus.getName());

                    schoolVOList.add(vo);
                }
            }
        }

        SearchSchoolRespDTO respDTO = new SearchSchoolRespDTO();
        respDTO.setSchools(schoolVOList);
        return ApiResponse.success(respDTO);
    }

    @Override
    public ApiResponse<BindSchoolRespDTO> bindSchool(BindSchoolReqDTO req) {
        long currentId = BaseContext.getCurrentId();
        int rows = schoolRepository.updateBindSchool(currentId, req.getSchoolId(), req.getCampusId());

        if (rows <= 0) {
            return ApiResponse.error(ResultCode.FAIL_BIND.code(), ResultCode.FAIL_BIND.msg());
        }

        log.info(TAG + " bindSchool success, userId: " + currentId + ", schoolId: " + req.getSchoolId() + ", campusId: " + req.getCampusId());
        BindSchoolRespDTO result = new BindSchoolRespDTO(true, "绑定成功");
        return ApiResponse.success(result);
    }

    @Override
    public ApiResponse<List<GetLocationRespDTO>> getLocations(GetLocationReqDTO req) {
        School school = schoolRepository.findSchoolById(req.getSchoolId());
        if (school == null) {
            return ApiResponse.error(ResultCode.UNEXIST_SCHOOL.code(), ResultCode.UNEXIST_SCHOOL.msg());
        }

        Campus campus = schoolRepository.findCampusById(req.getCampusId());
        if (campus == null) {
            return ApiResponse.error(ResultCode.UNEXIST_CAMPUS.code(), ResultCode.UNEXIST_CAMPUS.msg());
        }

        if (campus.getSchoolId() != req.getSchoolId()) {
            return ApiResponse.error(ResultCode.UNMATCH_CAMPUS.code(), ResultCode.UNMATCH_CAMPUS.msg());
        }

        List<Location> locations = locationRepository.findLocationsByCampusId(req.getCampusId());
        List<GetLocationRespDTO> result = locations.stream()
                .map(location -> new GetLocationRespDTO(
                        req.getSchoolId(),
                        school.getName(),
                        req.getCampusId(),
                        campus.getName(),
                        location.getDetail(),
                        location.getSort(),
                        location.getStatus(),
                        location.getType()
                ))
                .collect(Collectors.toList());
        return ApiResponse.success(result);
    }
}
