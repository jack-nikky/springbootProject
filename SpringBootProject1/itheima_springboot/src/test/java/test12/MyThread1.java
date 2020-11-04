package test12;

public class MyThread1 extends Thread {
    @Override
    public void run() {
        while(test.i%1==1){
            System.out.println("two:"+test.i);
            test.i++;
        }
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
