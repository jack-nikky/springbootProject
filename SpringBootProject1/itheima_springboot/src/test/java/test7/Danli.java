package test7;

public class Danli {
    private static Danli danli=null;

    public static Danli getObgect() throws IllegalAccessException, InstantiationException {
        if(danli==null){
            danli = Danli.class.newInstance();
        }
        return danli;
    }
}
