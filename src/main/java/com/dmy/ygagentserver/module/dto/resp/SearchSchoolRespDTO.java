package com.dmy.ygagentserver.module.dto.resp;

import com.dmy.ygagentserver.module.vo.SchoolVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchSchoolRespDTO {
    private List<SchoolVO> schools;
}
