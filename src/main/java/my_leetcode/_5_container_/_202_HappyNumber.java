package my_leetcode._5_container_;

/*
编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」定义为：
对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果 可以变为  1，那么这个数就是快乐数。

如果 n 是快乐数就返回 True ；不是，则返回 False 。

 
编写一个算法来判断一个数 n 是不是快乐数。

示例：

输入：19
输出：true
解释：
12 + 92 = 82  1的平方+9的平方=82
82 + 22 = 68  8的平方+2的平方=68
62 + 82 = 100 6的平方+8的平方=100
12 + 02 + 02 = 1  1的平方+0的平方+0的平方=1

 */

import java.util.HashSet;
import java.util.Set;

/*
// todo  解题关键
1.最终会得到 1。
2.最终会进入循环。
3.值会越来越大，最后接近无穷大。  [这种情况不存在]
第三个情况比较难以检测和处理。我们怎么知道它会继续变大，而不是最终得到 11 呢？我们可以仔细想一想，每一位数的最大数字的下一位数是多少。

Digits	Largest	Next
1	9	81
2	99	162
3	999	243
4	9999	324
13	9999999999999	1053
对于 3 位数的数字，它不可能大于 243。这意味着它要么被困在 243 以下的循环内，要么跌到 11。4 位或 4 位以上的数字在每一步都会丢失一位，直到降到 3 位为止。
所以我们知道，最坏的情况下，算法可能会在 243 以下的所有数字上循环，然后回到它已经到过的一个循环或者回到 1。但它不会无限期地进行下去，所以我们排除第三种选择。

即使在代码中你不需要处理第三种情况，你仍然需要理解为什么它永远不会发生，这样你就可以证明为什么你不处理它。

 */
//https://leetcode-cn.com/problems/happy-number/solution/kuai-le-shu-by-leetcode-solution/
public class _202_HappyNumber {

//    方法一：用 HashSet 检测循环            //  todo 先记着这一步吧！！！  求每一个的平方和
        // 1 取余 2 取整 3 求和
        private int getNext1(int n) { // 输入一个数，得到每位数字的平方和
            int totalSum = 0;
            while (n > 0) {
                int d = n % 10;   // 取余，得到每一位
                n = n / 10;      // 重新得到n
                totalSum += d * d;
            }
            return totalSum;
        }

        public boolean isHappy1(int n) {        //  退出条件 n==1 或者set中包含了n
            Set<Integer> seen = new HashSet<>();
                while (!seen.contains(n)) {     // 只要没有进入循环 while (n != 1 && !seen.contains(n))
                seen.add(n);
                n = getNext1(n);
            }
            return n == 1;
        }




//    方法二：快慢指针法
    public int getNext2(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
    public boolean isHappy2(int n) {
        int slowRunner = n;
        int fastRunner = getNext2(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext2(slowRunner);
            fastRunner = getNext2(getNext2(fastRunner));
        }
        return fastRunner == 1;
    }


//    https://leetcode-cn.com/problems/happy-number/solution/202java-ha-xi-biao-shuang-zhi-zhen-liang-chong-fan/
//如下解法也不错
}
