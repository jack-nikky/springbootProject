package singleton;

public class Singleton2 {
    private static Singleton2 instance = null;
    private Singleton2(){}
    public Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }
}
