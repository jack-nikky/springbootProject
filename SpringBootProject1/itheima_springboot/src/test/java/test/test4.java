package test;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;


public class test4 {
    public static void main(String[] args) throws Exception {
        Properties pros = new Properties();
        pros.load(new FileReader("itheima_springboot/src/test/resources/class.properties"));
        String classname = pros.getProperty("classname");
        String methodname = pros.getProperty("methodname");
        Class<?> c = Class.forName(classname);

        Field field = c.getDeclaredField("name");
        field.setAccessible(true);
        System.out.println(field.get(c.newInstance()));
    }
}
