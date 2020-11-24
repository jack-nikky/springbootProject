package test15;

//主体循环部分才5行。其实是有规律可循的。将每一层的四个边角搞清楚就可以打印出来了
/*假设数组4*3
1 2 3
4 5 6
7 8 9
1 2 3
*
我们的结果应该是1 2 3 6 9 3 2 1 7 4 5 8
首先分析层数：这个例子是2
    应该用小的边来分析：与最小边长x的奇偶有关，x为偶数的话，直接x/2，为奇数的话（x+1）/2
    因为是整除，所以无论奇偶，都可以用（x+1)/2来表示层数

然后我们对按层数对数组进行遍历
当我们对第i层进行遍历时：
首先：（n为数组行数，m为列数）
    从左到右：行固定为i， 列j范围为 i <= j <= m-i-1              此时list：1 2 3
    从上到下：列固定为 m-i-1, 行j范围为 i+1<=j<=n-i-1        此时list：1 2 3 6 9 3
    从右到左：行固定为n-i-1, 列j范围为 m-i-2 >= j >= i       此时list:1 2 3 6 9 3 2 1
    从下到上：列固定为i，行j 范围为 n-i-2 >= j >= i           此时list:1 2 3 6 9 3 2 1 7 4
*/

import java.util.ArrayList;
public class test {
    public ArrayList<Integer> printMatrix(int [][] array) {
        ArrayList<Integer> result = new ArrayList<Integer> ();
        if(array.length==0) return result;
        int n = array.length,m = array[0].length;
        if(m==0) return result;
        int layers = (Math.min(n,m)-1)/2+1;//这个是层数
        for(int i=0;i<layers;i++){
            for(int j = i;j<m-i;j++) result.add(array[i][j]);//左至右
            for(int j=i+1;j<n-i;j++) result.add(array[j][m-i-1]);//右上至右下
            for(int j=m-i-2;(j>=i)&&(n-i-1!=i);j--) result.add(array[n-i-1][j]);//右至左
            for(int j=n-i-2;(j>i)&&(m-i-1!=i);j--) result.add(array[j][i]);//左下至左上
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(42==42.00);
    }
}