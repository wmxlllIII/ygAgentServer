package com.dmy.ygagentserver.common.util;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeUtil {

    public static long dateTimeToSecond(LocalDateTime dateTime) {
        return dateTime
                .atZone(ZoneId.of("Asia/Shanghai"))
                .toEpochSecond();
    }
}
