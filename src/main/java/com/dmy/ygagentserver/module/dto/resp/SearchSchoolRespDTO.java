package com.dmy.ygagentserver.module.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchSchoolRespDTO {
    private long id;
    private String name;
    private String province;
    private String city;

}
