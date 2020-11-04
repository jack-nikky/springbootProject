package test13;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put('a',"a");
        map.put("a","string");
        System.out.println(map.get('a'));
        System.out.println(map.get("a"));
    }

}
