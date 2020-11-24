package test15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;
class As{
    public int val = 0;
    As(int a){
        val = a;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<As> as = new ArrayList<>();
        as.add(new As(5));
        as.add(new As(3));
        as.add(new As(2));
        as.add(new As(1));
        Collections.sort(as,new Comparator<As>() {
            @Override
            public int compare(As o1, As o2) {
                return o1.val-o2.val;
            }
        });
        for(As a:as){
            System.out.println(a.val);
        }
    }

}
