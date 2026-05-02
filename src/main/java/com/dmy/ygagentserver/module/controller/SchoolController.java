package com.dmy.ygagentserver.module.controller;

import com.dmy.ygagentserver.common.result.ApiResponse;
import com.dmy.ygagentserver.module.dto.req.BindSchoolReqDTO;
import com.dmy.ygagentserver.module.dto.req.GetLocationReqDTO;
import com.dmy.ygagentserver.module.dto.req.SearchSchoolReqDTO;
import com.dmy.ygagentserver.module.dto.resp.BindSchoolRespDTO;
import com.dmy.ygagentserver.module.dto.resp.GetLocationRespDTO;
import com.dmy.ygagentserver.module.dto.resp.SearchSchoolRespDTO;
import com.dmy.ygagentserver.module.service.SchoolService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/search")
    @ApiOperation("搜索")
    public ApiResponse<SearchSchoolRespDTO> login(@RequestBody SearchSchoolReqDTO req) {
        return schoolService.searchSchool(req);
    }

    @PostMapping("/bind")
    @ApiOperation("绑定学校")
    public ApiResponse<BindSchoolRespDTO> bindSchool(@RequestBody BindSchoolReqDTO req) {
        return schoolService.bindSchool(req);
    }

    @PostMapping("/getLocation")
    @ApiOperation("获取校内地点")
    public ApiResponse<List<GetLocationRespDTO>> getLocations(@RequestBody GetLocationReqDTO req) {
        return schoolService.getLocations(req);
    }
}
