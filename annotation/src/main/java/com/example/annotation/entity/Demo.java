package com.example.annotation.entity;

import com.example.annotation.annotation.MyTest4;

@MyTest4(value = "class",bbb={"class1","class2"})
public class Demo {
    @MyTest4(value = "method",bbb={"method1","method2"})
    void test1(){
        System.out.println("test1");
    }
}
