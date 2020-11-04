package test10;

public class test {
    private  String aaa;
    {
        aaa="dsd";
    }
    test(){
        System.out.println(aaa);
        System.out.println("无参。。。。。");
    }

    public static void main(String[] args) {
        test t  = new test();
        
    }
}
