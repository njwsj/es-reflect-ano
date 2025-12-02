package com.example.reflect.frame;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class ObjectFrame {
    public static void saveObject(Object obj) throws Exception {
        PrintStream ps = new PrintStream(new FileOutputStream("src/main/java/com/example/reflect/outfile/output.txt", true));
        Class<?> c = obj.getClass();
        String simpleName = c.getSimpleName();
        ps.println("======"+simpleName+"======"+"start");
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            String value = field.get(obj)+"";
            ps.println(fieldName + "=" + value);
        }
        ps.println("保存时间: " + new java.util.Date());
        ps.println("======"+simpleName+"======"+"end");
        ps.close();
    }
}
