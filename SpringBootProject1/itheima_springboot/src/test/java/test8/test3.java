package test8;

//模拟快慢指针相遇
public class test3 {
    public static void main(String[] args) {
            mini(30);
    }

    public static void mini(int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i <= 2 * n) {
            k++;
            i++;
            i = i % (n+1);
            j += 2;
            j = j % (n+1);
            System.out.println("第" + k + "次，i=" + i + "---,j=" + j);
            if (i == j) {
                System.out.println("第" + k + "次，i,j=" + i + "两者相遇");
                break;
            }
        }
    }


}
