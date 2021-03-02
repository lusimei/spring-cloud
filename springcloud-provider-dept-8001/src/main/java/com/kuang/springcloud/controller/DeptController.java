package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    };

    @GetMapping("/getById/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        return deptService.queryById(id);
    };

    @GetMapping("/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    };
}
