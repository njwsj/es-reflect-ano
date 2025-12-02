package com.example.annotation.entity;

import com.example.annotation.annotation.MyTest1;
import com.example.annotation.annotation.MyTest2;
import com.example.annotation.annotation.MyTest3;

@MyTest1("aaa")
@MyTest2(bbb = "bbb")
@MyTest3
public class Test {
    @MyTest3
    private String name;
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
