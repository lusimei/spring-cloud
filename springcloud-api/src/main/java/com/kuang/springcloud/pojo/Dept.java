package com.kuang.springcloud.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class Dept implements Serializable {

    private Long deptNo;

    private String dname;

    private String dbSource;
}
