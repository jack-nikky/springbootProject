package test2;

interface InterfaceA {
    default void foo() {
        System.out.println("InterfaceA foo");
    }
}

interface InterfaceB extends InterfaceA {
}

interface InterfaceC extends InterfaceA {
    @Override
    default void foo() {
        System.out.println("InterfaceC foo");
    }
}

interface InterfaceD extends InterfaceA {
    @Override
    void foo();
}

public class Test {
    public static void main(String[] args) {
        new InterfaceB(){}.foo(); // 打印：“InterfaceA foo”
        new InterfaceC() {}.foo(); // 打印：“InterfaceC foo”
        new InterfaceD() {
            @Override
            public void foo() {
                System.out.println("InterfaceD foo");
            }
        }.foo(); // 打印：“InterfaceD foo”

        // 或者使用 lambda 表达式
        ((InterfaceD) () -> System.out.println("InterfaceD foo")).foo();
    }
}
