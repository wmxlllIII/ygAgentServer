package com.dmy.ygagentserver.module.service;

import com.dmy.ygagentserver.common.result.ApiResponse;
import com.dmy.ygagentserver.module.dto.req.BindSchoolReqDTO;
import com.dmy.ygagentserver.module.dto.req.GetLocationReqDTO;
import com.dmy.ygagentserver.module.dto.req.SearchSchoolReqDTO;
import com.dmy.ygagentserver.module.dto.resp.BindSchoolRespDTO;
import com.dmy.ygagentserver.module.dto.resp.GetLocationRespDTO;
import com.dmy.ygagentserver.module.dto.resp.SearchSchoolRespDTO;

import java.util.List;

public interface SchoolService {
    ApiResponse<SearchSchoolRespDTO> searchSchool(SearchSchoolReqDTO req);

    ApiResponse<BindSchoolRespDTO> bindSchool(BindSchoolReqDTO req);

    ApiResponse<List<GetLocationRespDTO>> getLocations(GetLocationReqDTO req);
}
