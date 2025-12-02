package com.example.reflect;

import com.example.reflect.entity.Student;
import com.example.reflect.entity.Teacher;
import com.example.reflect.frame.ObjectFrame;
import org.junit.jupiter.api.Test;

public class ObjectFrameTest {
    @Test
    public void testObjectFrame() throws Exception {
        Teacher teacher = new Teacher("zhangsan", 18.00);
        Student student = new Student("lisi", 18, "男");
        ObjectFrame.saveObject(teacher);
        ObjectFrame.saveObject(student);
    }
}
