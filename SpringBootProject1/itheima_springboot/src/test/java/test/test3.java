package test;

import java.lang.reflect.Method;

public class test3 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> c = Class.forName("test.User");
        User user = new User();
        //Method[] method = user.getClass().getMethods();
        Method[] methods = c.getMethods();
        for(Method i:methods){
            System.out.println(i);
        }
    }
}
