package com.dmy.ygagentserver.module.service.impl;

import com.dmy.ygagentserver.common.exception.BusinessException;
import com.dmy.ygagentserver.common.result.ApiResponse;
import com.dmy.ygagentserver.common.result.ResultCode;
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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ApiResponse<List<SearchSchoolRespDTO>> searchSchool(SearchSchoolReqDTO req) {
        List<School> schools = schoolRepository.findSchoolByKey(req.getKeyword());
        List<SearchSchoolRespDTO> result = schools.stream()
                .map(school -> new SearchSchoolRespDTO(
                        school.getId(),
                        school.getName(),
                        school.getProvince(),
                        school.getCity()
                ))
                .collect(Collectors.toList());
        return ApiResponse.success(result);
    }

    @Override
    public ApiResponse<BindSchoolRespDTO> bindSchool(BindSchoolReqDTO req) {
        int rows = schoolRepository.updateBindSchool(req.getUserId(), req.getSchoolId(), req.getCampusId());

        if (rows <= 0) {
            log.warn(TAG + " bindSchool failed, userId: " + req.getUserId());
            throw new BusinessException(ResultCode.FAIL_BIND);
        }

        log.info(TAG + " bindSchool success, userId: " + req.getUserId() + ", schoolId: " + req.getSchoolId() + ", campusId: " + req.getCampusId());
        BindSchoolRespDTO result = new BindSchoolRespDTO(true, "绑定成功");
        return ApiResponse.success(result);
    }

    @Override
    public ApiResponse<List<GetLocationRespDTO>> getLocations(GetLocationReqDTO req) {
        School school = schoolRepository.findSchoolById(req.getSchoolId());
        if (school == null) {
            log.warn(TAG + " getLocations failed, school not found, schoolId: " + req.getSchoolId());
            throw new BusinessException(ResultCode.UNEXIST_SCHOOL);
        }

        Campus campus = schoolRepository.findCampusById(req.getCampusId());
        if (campus == null) {
            log.warn(TAG + " getLocations failed, campus not found, campusId: " + req.getCampusId());
            throw new BusinessException(ResultCode.UNEXIST_CAMPUS);
        }

        if (campus.getSchoolId() != req.getSchoolId()) {
            log.warn(TAG + " getLocations failed, campus not belong to school, schoolId: " + req.getSchoolId() + ", campusId: " + req.getCampusId());
            throw new BusinessException(ResultCode.UNMATCH_CAMPUS);
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
