package test14;

import java.lang.reflect.Method;
import java.util.LinkedList;

public class test5 {
    public static void main(String[] args) {
        LinkedList<Integer>  ls = new LinkedList<>();
        Method[] methods = ls.getClass().getMethods();
        for(Method method:methods){
            System.out.println(method);
        }
    }

}
