package test12;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("one:"+test.i);
        test.i++;
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
