package com.Auth.JWTConfig;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @ProjectName: springmvc
 * @Package: com.Auth.JWTConfig
 * @ClassName: User
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/10/12 15:28
 * @Version: 1.0
 */
public class User{
    private String userName;
    private Integer age;

    public User() {
    }

    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
