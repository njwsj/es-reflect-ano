package com.example.reflect;

import com.example.reflect.entity.Student;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

public class StudentReflectionTest {
    @Test
    public void testStudentReflection() throws Exception {
        Student student = new Student();
        Class<Student> studentClass = Student.class;
        System.out.println(Student.class);
        System.out.println(Class.forName("com.example.reflect.entity.Student"));
        System.out.println(student.getClass());
        System.out.println("======类基本信息============");
        System.out.println(studentClass.getName());
        System.out.println(studentClass.getAnnotation(Data.class));
        System.out.println(studentClass.getSigners());
        System.out.println("======类构造器（无参）============");
        System.out.println(studentClass.getConstructor());//public
        System.out.println(studentClass.getDeclaredConstructor());//全部
        System.out.println("======类构造器（有参）============");
        System.out.println(studentClass.getConstructor(String.class,int.class,String.class));
        System.out.println(studentClass.getDeclaredConstructor(String.class,int.class,String.class));
        System.out.println("======类构造器（循环遍历）============");
        Constructor<?>[] constructors = studentClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName() + " " + constructor.getParameterCount());
        }


    }
}
