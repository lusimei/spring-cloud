package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.kuang.springcloud"})
//@ComponentScan(basePackages = {"com.kuang.springcloud"})
public class DeptConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeignApplication.class,args);
    }
}
