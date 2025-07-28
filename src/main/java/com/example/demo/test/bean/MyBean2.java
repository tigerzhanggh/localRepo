package com.example.demo.test.bean;

import org.springframework.stereotype.Component;

@Component
public class MyBean2 {
    private String name2;
    private Integer age2;

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public Integer getAge2() {
        return age2;
    }

    public void setAge2(Integer age2) {
        this.age2 = age2;
    }
}
