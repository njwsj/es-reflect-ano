package com.example.annotation;

import com.example.annotation.annotation.MyTest4;
import com.example.annotation.entity.Demo;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationTest {
    @Test
    public void parseAnnotationClass(){
        Class demoClass = Demo.class;
        //获取当前类上的注解
        Annotation[] declaredAnnotations = demoClass.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println(declaredAnnotation);
        }
        //获取指定的注解对象
        Annotation declaredAnnotation = demoClass.getDeclaredAnnotation(MyTest4.class);
        System.out.println(declaredAnnotation);
        //判断当前类是否包含指定的注解
        System.out.println(demoClass.isAnnotationPresent(MyTest4.class));

    }

    @Test
    public void parseAnnotationMethod() throws Exception {
        Class demoClass = Demo.class;
        Method test1 = demoClass.getDeclaredMethod("test1");
        Annotation[] declaredAnnotations = test1.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println(declaredAnnotation);
        }
        System.out.println(test1.getDeclaredAnnotation(MyTest4.class));
        System.out.println(test1.isAnnotationPresent(MyTest4.class));
    }
}
