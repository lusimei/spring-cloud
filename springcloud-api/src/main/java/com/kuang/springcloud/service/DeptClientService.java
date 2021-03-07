package com.kuang.springcloud.service;

import com.kuang.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallBackFactory.class)
@Component
public interface DeptClientService {

    @RequestMapping("/getById/{id}")
    Dept get(@PathVariable("id") Long id);

    @RequestMapping("/list")
    List<Dept> list();

    @RequestMapping("/add")
    boolean add(Dept dept);
}
