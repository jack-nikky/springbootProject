package test16;


public class test {
    public static void main(String[] args) {
        A a = new test.A();
        A a2 = new A();

        B b = new test().new B();
    }
    static class A{}
    class B{}
}
