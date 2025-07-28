package com.example.demo.test.bean;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private String idNo;
    private String stuName;

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
}
