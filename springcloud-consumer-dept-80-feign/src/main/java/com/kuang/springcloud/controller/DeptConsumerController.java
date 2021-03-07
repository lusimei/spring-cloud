package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService service;

    @RequestMapping("/consumer/dept/{id}")
    public Dept get(@PathVariable("id")Long id){
        return service.get(id);
    }

    @RequestMapping("/consumer/list")
    public List<Dept> list(){
        return service.list();
    }

    @RequestMapping("/consumer/add")
    public boolean add(Dept dept){
        return service.add(dept);
    }
}
