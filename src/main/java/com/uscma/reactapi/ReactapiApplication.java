package com.uscma.reactapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ReactapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactapiApplication.class, args);
    }

}
