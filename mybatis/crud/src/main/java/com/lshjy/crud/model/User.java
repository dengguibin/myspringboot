package com.lshjy.crud.model;

import lombok.Data;

@Data
public class User {
    private Integer userId;

    private String userName;

    private String password;

    private String phone;

    private Integer age;

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}