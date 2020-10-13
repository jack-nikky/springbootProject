package test9;

public class test {


    public static void main(String[] args) {
        A a = new A();
        a.setName("jiaxin");
        System.out.println(a.getName());
        change(a);
        System.out.println(a.getName());
    }

    private static void change(A a) {
        a.setName("itheima");
    }
}
