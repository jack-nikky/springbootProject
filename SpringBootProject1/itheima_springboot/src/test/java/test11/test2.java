package test11;

import java.util.HashMap;
import java.util.Map;

public class test2 {
    private static final float RATIO = 1.08f;
    public static void main(String[] args) {
        float xinshui = 6500;
        System.out.println("初始工资为："+xinshui);
        System.out.println("-------------------------------");
        for(int i=1;i<10;i++){
            xinshui *= RATIO;
            System.out.println("第"+i+"年第一次调薪后："+xinshui+"元");
            xinshui *= RATIO;
            System.out.println("第"+i+"年第二次调薪后："+xinshui+"元");

            HashMap<Integer,Integer> map = new HashMap<>();
            map.containsKey("dc");
        }
    }


}
