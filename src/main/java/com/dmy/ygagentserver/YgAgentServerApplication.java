package com.dmy.ygagentserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.dmy.ygagentserver.module.repository")
@SpringBootApplication
public class YgAgentServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YgAgentServerApplication.class, args);
    }

}
