package algorithm;

/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */

/*
可以用动态规划来求解该题
跳到第n个台阶，只有两种可能
从第n-1个台阶跳1个台阶
从第n-2个台阶跳2个台阶
只需求出跳到第n-1个台阶和第n-2个台阶的可能跳法即可
F（n）:n个台阶的跳法
递推公式：F（n）=F（n-1）+F（n-2）
不难发现这是一个斐波那契数列
起始条件为F（0）=1，F（1）=1
 */

public class _8_跳台阶 {
    public static void main(String[] args) {

    }

//解法一：自底向上，使用迭代
    public static int JumpFloor(int target) {
        if(target==0)
            return 1;
        if(target==1)
            return 1;
        int si_1=1;
        int si_2=1;
        int result=0;
        for(int i=2;i<=target;i++){
            result=si_1+si_2;
            si_2=si_1;
            si_1=result;
        }
        return result;
    }


   // 解法二：自顶向下，使用递归

    public static int JumpFloor2(int target) {
        if(target==1)
            return 1;
        else if(target==2)
            return 2;
        return JumpFloor(target-1)+JumpFloor(target-2);
    }

}
