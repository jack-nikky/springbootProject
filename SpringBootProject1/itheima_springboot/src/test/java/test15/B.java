package test15;

class A{
    A(int a){
        System.out.println(a);
    }
}

public class B extends A{
    B() {
        //System.out.println(a);
        super(2);
    }
}
