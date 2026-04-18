package com.dmy.ygagentserver.module.user.service;

import com.dmy.ygagentserver.module.user.dto.req.BindSchoolReqDTO;
import com.dmy.ygagentserver.module.user.dto.req.GetLocationReqDTO;
import com.dmy.ygagentserver.module.user.dto.req.SearchSchoolReqDTO;
import com.dmy.ygagentserver.module.user.dto.resp.BindSchoolRespDTO;
import com.dmy.ygagentserver.module.user.dto.resp.GetLocationRespDTO;
import com.dmy.ygagentserver.module.user.dto.resp.SearchSchoolRespDTO;

import java.util.List;

public interface SchoolService {
    List<SearchSchoolRespDTO> searchSchool(SearchSchoolReqDTO req);

    BindSchoolRespDTO bindSchool(BindSchoolReqDTO req);

    List<GetLocationRespDTO> getLocations(GetLocationReqDTO req);
}
