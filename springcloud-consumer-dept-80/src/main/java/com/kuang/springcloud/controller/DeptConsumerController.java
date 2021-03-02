package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL = "http://localhost:8001/";

    @RequestMapping("/consumer/dept/{id}")
    public Dept get(@PathVariable("id")Long id){
        return restTemplate.getForObject(REST_URL+"/getById/"+id,Dept.class);
    }

    @RequestMapping("/consumer/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL+"/list",List.class);
    }

    @RequestMapping("/consumer/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL+"/add",dept,Boolean.class);
    }
}
