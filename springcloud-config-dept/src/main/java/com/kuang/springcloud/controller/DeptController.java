package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    };

    @GetMapping("/getById/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if(dept == null)
            throw new RuntimeException("id =->"+id+"找不到对应的信息");
        return dept;
    };

    @GetMapping("/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    };

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = client.getServices();
        System.out.println("discovery => services:"+services);
        List<ServiceInstance> instances = client.getInstances("springcloud-provider-dept");
        for (ServiceInstance service : instances) {
            System.out.println(service.getHost()+"\t"+service.getPort()+"\t"+service.getUri()+"\t"+service.getInstanceId());
        }
        return this.client;
    }
}
