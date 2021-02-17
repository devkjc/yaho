package com.toy.yaho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class YahoApplication {

    public static void main(String[] args) {
        SpringApplication.run(YahoApplication.class, args);
    }

}
