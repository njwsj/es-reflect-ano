package com.example.reflect.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Student {

    public static String address;

    public final static String country = "中国";

    private String name;

    private int age;

    private String sex;

    public Student(){
        System.out.println("无参数构造");
    }

    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Integer add(Integer a,Integer b){
        return a+b;
    }
}
