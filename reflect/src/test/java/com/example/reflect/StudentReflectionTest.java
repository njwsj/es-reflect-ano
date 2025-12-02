package com.example.reflect;

import com.example.reflect.entity.Student;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StudentReflectionTest {
    @Test
    public void testStudentReflection() throws Exception {
        //Student student = new Student();
        Class<Student> studentClass = Student.class;
        System.out.println(Student.class);
        System.out.println(Class.forName("com.example.reflect.entity.Student"));
        //System.out.println(student.getClass());
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


    @Test
    public void ObjNew() throws Exception {
        Class studentClass = Student.class;
        //获取无参构造器
        Constructor declaredConstructor = studentClass.getDeclaredConstructor();
        // 关键：关闭访问权限检查
        declaredConstructor.setAccessible(true);
        Student student = (Student) declaredConstructor.newInstance();
        System.out.println(student);
        //获取有参数构造器
        Constructor constructor = studentClass.getDeclaredConstructor(String.class, int.class, String.class);
        constructor.setAccessible(true);
        Student student1 = (Student) constructor.newInstance("张三", 18, "男");
        System.out.println(student1);
    }

    @Test
    public void testGetField() throws Exception {
        Class studentClass = Student.class;

        //获取字段
        System.out.println(studentClass.getFields().length); // 获取所有public字段，包括继承的
        for (Field field : studentClass.getFields()) {
            System.out.println(field.getName());
        }
        System.out.println(studentClass.getDeclaredFields().length); // 获取所有字段
        for (Field field : studentClass.getDeclaredFields()) {
            System.out.println(field.getName());
        }
        System.out.println(studentClass.getField("address"));//只能获取到public字段
        System.out.println(studentClass.getDeclaredField("name"));//获取所有字段，包括继承的

        //赋值
        Field nameField = studentClass.getDeclaredField("name");
        nameField.setAccessible(true); // 关闭访问权限检查
        Student student1 = new Student();
        nameField.set(student1, "张三");
        System.out.println(student1);

        //取值
        System.out.println(nameField.get(student1));
    }

    @Test
    public void testGetMethod() throws Exception {
        Class studentClass = Student.class;
        System.out.println(studentClass.getMethods().length);
        //获取全部成员方法
        for (Method method : studentClass.getMethods()) {
            System.out.println(method.getName()+"----"+method.getReturnType());
        }
        System.out.println("==================================");
        System.out.println(studentClass.getDeclaredMethods().length);
        for (Method method : studentClass.getDeclaredMethods()) {
            System.out.println(method.getName()+"----"+method.getReturnType());
        }
        //获取某个成员方法
        Method m = studentClass.getMethod("getName");//获取到getName方法  方法参数为空 就不用写
        System.out.println(m.getName()+"----"+m.getReturnType()+"----"+m.getParameterCount());
        Method add = studentClass.getMethod("add", Integer.class, Integer.class);
        System.out.println(add.getName()+"----"+add.getReturnType()+"----"+add.getParameterCount());

        //触发方法
        Student student = new Student("zhang",18,"nan");
        Object invokeReturn = m.invoke(student);
        System.out.println(invokeReturn);
        Object addReturn = add.invoke(student, 1, 2);
        System.out.println(addReturn);
    }
}
