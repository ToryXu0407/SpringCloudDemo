package com.toryxu.eurekaclient2;

import lombok.Data;

/**
 * @Author: toryxu
 * @Date: 2019/5/21 0021 19:29
 * @Version 1.0
 */
@Data
public class User {

    String name ;
    Integer age;

    public User(){

    }
    public  User(String name,int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
