package test7;

public class B extends A {
    public static  String TEST="BBBBBB";
    B(){
        System.out.println("子类初始化");
    }
}
class c{
    public static void main(String[] args) {
        B b =new B();
        //System.out.println(A.STATE);
    }
}
