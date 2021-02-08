package CSDC;

public class test3 {
    public static void main(String[] args) throws InterruptedException {
        Integer a = 3;
        synchronized (a){
            a.wait(100);
        }

        System.out.println(a);
    }
}
