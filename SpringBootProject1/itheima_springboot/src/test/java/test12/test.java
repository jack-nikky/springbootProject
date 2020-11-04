package test12;

public class test {
    public static volatile int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread one = new MyThread();
        Thread two = new MyThread1();
        one.start();
        two.start();
    }
}
