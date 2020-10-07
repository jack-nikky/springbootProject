package test6;

class A{
    private int aa;
    A(int a){
       aa =a;
    }
    public int getA(){
        return aa;
    }
    public void setA(int a){
        aa = a;
    }
}

public class test {


    public static void main(String[] args) {
        A a = new A(2);
        A b = a;
        System.out.println(a.getA());
        b.setA(5);
        System.out.println(a.getA());

    }
}
