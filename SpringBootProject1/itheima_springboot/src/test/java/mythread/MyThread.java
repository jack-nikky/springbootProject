package mythread;

import java.util.concurrent.Callable;

public class MyThread implements Callable {
    private String string;
    MyThread(String str){
        string = str;
    }

    @Override
    public Object call() throws Exception {
        return string;
    }
}
