package _08_highFrequency;

/**
 * https://leetcode-cn.com/problems/powx-n/
 */
/*
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/powx-n
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution {
    public double myPow(double x, int n) {

    }
}
 */
public class _50_Pow {
    // T(n) = T(n/2) + O(1) = O(logn)
    public double myPow2(double x, int n) {
        if (n == 0) return 1;
        if (n == -1) return 1 / x;
        double half = myPow(x, n >> 1);  // n >> 1   取n/2   得到一半的结果
        half *= half;                       //                   一半的结果要与另一半作相乘
        // 是否为奇数
        return ((n & 1) == 1) ? (half * x) : half;  // 如果是奇数 half再乘以一个x，如果是偶数直接乘以half
    }

    /*  快速幂 : 分治
        1. 和1 按位与( &1 ) 取出最后一位二进制。   n & 1 拿出（每一个）最后一个二进制位  示例 21 = (10101)
        2. 取出最后一位之后，向右移一位。抛弃最后一位二进制。
        右移一位，前面空位用符号位来补 [ 如果是负数，补1 ; 如果是正数，补0 ]
       a. 和1 按位与，取出最后一个二进制位
        10101
       &00001
       ------
            1

       b. 右移一位
        0b10101 >> 1        // 右移一位
        0b01010             // 结果

      c. 和1 按位与
        0b01010
        & 00001
       ---------
              0
     */
    // Test 和1 按位与取最后一个二进制位   右移一位，抛弃最后一位二进制

    public static double myPowTest(double x, int n) {

        double res = 1.0;
        while (n > 0) {
            System.out.println( n & 1 );  // 把n的所有二进制位打印出来
            n >>= 1;   // n右移一位
        }
        return res;
    }
    public static double myPow(double x, int n) {
        long y = (n < 0) ? -((long) n) : n;
        double res = 1.0;
        while (y > 0) {
            if ((y & 1) == 1) {
                // 如果最后一个二进制位是1，就累乘上x
                res *= x;
            }
            x *= x;
            // 舍弃掉最后一个二进制位
            y >>= 1;
        }
        return (n < 0) ? (1 / res) : res;
    }





    public static void main(String[] args) {
        System.out.println(myPowTest(0,21 ));        //  21 二进制标识 (10101)
        System.out.println("--------------------------");
        System.out.println(myPowTest(0,10 ));        //  10 二进制标识 (1010)
        System.out.println(powMod1(-123, 455, 789));
        System.out.println(powMod(-123, 455, 789));

        int n1 = 7 ;
        System.out.println(n1 / 2);  // 3
        System.out.println(n1 >> 1); // 3

        int n2 = -7 ;
        System.out.println(n2 / 2);  // -3
        System.out.println(n2 >> 1); // -4

    }


//   public double myPow(double x, int n) {
////        return Math.pow(x,n);
//       //  但是对于 n<0的情况不适用了。例如 n= (-2)
//        while (n>0){
//            x *=x;
//            n--;
//        }
//        return x;
//    }



    /*

     */




    // --------- 扩展 --------------

    // 2^100 % 6  = (2^50 * 2^50) % 6 = ((2^50 % 6) * (2^50 % 6)) % 6
    // 2^101 % 6 = (2^50 * 2^50 * 2) % 6 = ((2^50 % 6) * (2^50 % 6) * (2 % 6)) % 6
    public static int powMod(int x, int y, int z) {
        if (y < 0 || z == 0) return 0;
        if (y == 0) return 1 % z;
        int half = powMod(x, y >> 1, z);
        half *= half;
        if ((y & 1) == 0) { // 偶数
            return half % z;
        } else { // 奇数
            return (half * (x % z)) % z;
        }
    }


    public static int powMod1(int x, int y, int z) {
        if (y < 0 || z == 0) return 0;
        int res = 1 % z;
        x %= z;
        while (y > 0) {
            if ((y & 1) == 1) {
                // 如果最后一个二进制位是1，就累乘上x
                res = (res * x) % z;
            }
            x = (x * x) % z;
            // 舍弃掉最后一个二进制位
            y >>= 1;
        }
        return res;
    }

}
