package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//EnableEurekaServer 服务端的启动类，可以接受其他服务的注册
public class EurekaConfig7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConfig7001.class,args);
    }
}
