package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudProvider8003Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProvider8003Application.class,args);
    }
}
