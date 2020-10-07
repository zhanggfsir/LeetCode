package algorithm;

/*
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */

public class _47_求1add2add3addn {
    public static void main(String[] args) {
        // 简单不行 的 解法        右移一位表示除以2
//        return (int) (Math.pow(n, 2) + n) >> 1;
        System.out.println(Sum_Solution2(10));
    }

    /*
        解题思路：
           1.需利用逻辑与的短路特性实现递归终止。
           2.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0；
           3.当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)。

           注 ：为什么要有 (sum+=Sum_Solution(n-1))>0
           必须保证 && 两边都是布尔型值
     */
    public  static  int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (n>0)&&( (sum+=Sum_Solution(n-1))>0 );

        return sum;
    }


    public static int Sum_Solution2(int n) {
        return sum(n);
    }
    static  int sum(int n){
        try{
            int i = 1%n;  //主要是实现 除数不能为零，为零则异常。。。。。。。。。i不用管他
            return n+sum(n-1);
        }
        catch(Exception e){
            System.out.println(6);
            return 0;   // 事实上 这一行代码执行了
        }
    }



//    public static int Sum_Solution2(int n) {
//        return sum(n);
//    }
//    static  int sum(int n){
//        try{
//            int i = 1%n;
//            return n+sum(n-1);
//        }
//        catch(Exception e){
//            System.out.println(6);
//            return 0;   // 事实上 这一行代码执行了
//        }
//    }

}

