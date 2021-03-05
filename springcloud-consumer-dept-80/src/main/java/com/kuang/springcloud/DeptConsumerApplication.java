package com.kuang.springcloud;

import com.kuang.myrule.KuangRule;
import com.kuang.myrule.MyRule;
import com.kuang.springcloud.config.ConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
/**
 * 使用自定义负载均衡规则时 应用名在此处一定要！！！大写！！！小写应用名无法生效,会使用默认的轮循规则
 */
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = KuangRule.class)
public class DeptConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerApplication.class,args);
    }
}
