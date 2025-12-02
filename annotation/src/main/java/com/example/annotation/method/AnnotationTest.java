package com.example.annotation.method;

import com.example.annotation.annotation.MyTest;

import java.lang.reflect.Method;

public class AnnotationTest {
    @MyTest
    public void test1(){
        System.out.println("test1");
    }

    public void test2(){
        System.out.println("test2");
    }
    @MyTest
    public void test3(){
        System.out.println("test3");
    }
    @MyTest
    public void test4(){
        System.out.println("test4");
    }

    public static void main(String[] args) {
        //获取class对象
        Class aClass = AnnotationTest.class;
        //获取类中所有方法
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            //判断方法上是否有MyTest注解
            if (method.isAnnotationPresent(MyTest.class)){
                try {
                    //调用方法
                    method.invoke(aClass.getDeclaredConstructor().newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
