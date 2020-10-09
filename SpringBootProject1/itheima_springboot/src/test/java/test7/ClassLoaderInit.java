package test7;

public class ClassLoaderInit {
    public static void main(String[] args) {
        Son son = new Son();
        System.out.println("----end-----");
    }
}
class Son extends Father{
    private int i=1;
    private long l =2l;
    static int ssi = 3;
    {
        System.out.println("1 son");
    }
    static {
        System.out.println("2 son static");
    }
    Son(){
        l=3l;
        System.out.println("3 son contructor");
    }
}
class Father{
    int ii;
    static  int fsi= 4;
    static {
        System.out.println("5father static");
    }
    static Son son =new Son();
    {
        System.out.println("4father");
    }

    Father(){
        ii = 1;
        System.out.println("6father constructor");
    }
}