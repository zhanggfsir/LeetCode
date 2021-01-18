package _88_VIP6.零钱兑换;

import java.util.Arrays;

public class _322_零钱兑换_my {





    /*
        ///////////////////////////// 默认 coins数组是逆序排序 ////////////////////////////
    //    	Arrays.sort(coins,(Integer f1,Integer f2)->{
//				return f1-f2;
//    	});
        // 可以简写为如下
//		Arrays.sort(coins, (Integer f1, Integer f2) -> f2 - f1); // 传入比较器，逆序排序  {25, 5, 10, 1}
        /*
        // coins 数组逆序排序
        Integer[] coin = new Integer[coins.length];
        for (int i = 0; i <coins.length ; i++) {
            coin[i]=coins[i];
        }
        // 可以用此方法进行逆序排序，但是int数组必须是Integer包装类 类型
        Arrays.sort(coin, Collections.reverseOrder());

        [2]
        3
        这种情况返回 -1

        */

    //   贪心策略得到的并非最优解  41 = 25 10 5 1 最优解 20 20 1
    static int  coinChange1(int[] coins, int amount) {
        int res = 0, i = 0;         // res面值可用数量 i 第i个
        while (i < coins.length) {
            if (amount < coins[i]) {	//逆序，先取出最大的face[0]=25  剩下的钱 < 当前值。面值不可用
                i++;        // 面值不可用数量
                continue;
            }
            amount -= coins[i]; // 面值是可用的
            res++;
        }
        return res;
    }





    ///////////////////////////// 递归 ////////////////////////////

    /**
     * 记忆化搜索（自顶向下的调用）
     *  dp[1]=dp[5]=dp[20]=dp[25]=1 凑够1、5、20、25分需要的最少硬币个数都是 1 枚
     */
    static int coinChange2(int n) {
        if (n < 1) return -1;
        int[] dp = new int[n + 1];		// 需要计算到凑过n分，下标要取到n，故长度为n+1
        int[] faces = {1, 5, 20, 25};
        for (int face : faces) {	// dp[1]=dp[5]=dp[20]=dp[25]=1； 直接赋值有bug。如果n=20，dp[25]越界
            if (n < face) break;
            dp[face] = 1;
        }
        return coinChange2(n, dp);
    }

    static int coinChange2(int n, int[] dp) {
        if (n < 1) return Integer.MAX_VALUE;
        if (dp[n] == 0) {	// 数组默认是0  dp[n] == 0 表示没有计算过
            int min1 = Math.min(coinChange2(n - 25, dp), coinChange2(n - 20, dp));
            int min2 = Math.min(coinChange2(n - 5, dp), coinChange2(n - 1, dp));
            dp[n] = Math.min(min1, min2) + 1;
        }
        return dp[n];	// 已经算过，直接返回。记忆化搜索
    }

    //	 此处类别 fib  1. fib有2个选项 零钱兑换有4个选项  2.都有重复计算--记忆化搜索 优化
    static int fib(int n){
        if(n<=2)
            return 1;
        return fib(1)+fib(2);
    }

    /**
     * 暴力递归（自顶向下的调用，出现了重叠子问题）
     *
     * 贪心策略得到的并非最优解 只看眼前
     *
     * dp(20) 凑到20分需要的最少硬币个数
     *
     * dp(41) 凑到41分需要的最少硬币个数
     *
     * dp(n)  凑到n分需要的最少硬币个数
     *
     * 第一次选择了25分的硬币，现在还差 n-25分
     * 	dp[n-25]凑到n-25需要的最少硬币个数
     * 如果第一次选择的了25分的硬币，那么 dp(n)=dp(n-25)+1 // +1，已经选择了1枚硬币，25分的硬币
     */
    static int coinChange2_(int n) {
        if (n < 1) return Integer.MAX_VALUE;
        if (n == 25 || n == 20 || n == 5 || n == 1) return 1;
        int min1 = Math.min(coinChange2_(n - 25), coinChange2_(n - 20));
        int min2 = Math.min(coinChange2_(n - 5), coinChange2_(n - 1));
        return Math.min(min1, min2) + 1;
    }


    ///////////////////////////// 动态规划 ////////////////////////////

    /*
        dp[n] 凑够n分需要的最少硬币个数
        dp[i]=min{dp[i-1],dp[i-5],dp[i-20],dp[i-25]}+1
             解读：dp[i] 凑够i分需要的最少硬币个数 = 凑够 {,,,}最小个数，再+1个硬币
        coins={5,20,25}
        amount=5 dp=[0, 0, 0, 0, 0, 1]
        amount=6 dp=[0, -2147483648, -2147483648, -2147483648, -2147483648, 1, -2147483647]
     */
    static int coinChange3_1(int[] coins,int amount) {
        if (amount < 1 || coins == null || coins.length == 0)
            return -1;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i < coin)
                    continue;
                min = Math.min(dp[i-coin],min);
            }
            dp[i]=min+1;
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }



    //  dp[n] 凑够n分需要的最少硬币个数
	/*
		// 如果amount数额凑不齐。即：如果没有任何一种硬币组合能组成总金额，返回 -1。
		coins={5,20,25}
		amount=5  dp=[0, -1, -1, -1, -1, 1]
		amount=6  dp=[0, -1, -1, -1, -1, 1, -1]
		amount=20 dp=[0, -1, -1, -1, -1, 1, -1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 1]
	 */
	// _322_零钱兑换
    static int coinChange3_2(int[] coins,int amount) {
        if (amount < 1 || coins == null || coins.length == 0)
            return -1;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i < coin)	// 示例 i=1 faces={5,20,25}没有1，此时dp[1]=-1 dp[1~4]=-1
                    continue;
                int v = dp[i - coin];
                // 如果面值不是从1开始，那么凑够dp[i]需要的最少硬币个数v就是-1.即：如果{5,20,25}，dp[1~4]=-1
                // 如果凑够dp[i]需要的最少硬币个数v >=min ，那么没有必要更新min.即：如果{20,5,25}，amount=20
                // 		v=dp[20-20]=0 (凑够0分需要0枚)；或者那么v=dp[20-15]=3 (凑够15分需要3枚)
                // 		则 v=3 答案舍弃
                if (v < 0 || v >= min)  // v=-1 即没法凑
                    continue;
                min = v;
            }
            if (min == Integer.MAX_VALUE) {	// 只要凑不齐,dp[i=-1]
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }

    ///////////////////////////// 动态规划 正解 注释版 ////////////////////////////

    //  dp[n] 凑够n分需要的最少硬币个数
	/*
		// 如果amount数额凑不齐。即：如果没有任何一种硬币组合能组成总金额，返回 -1。
		coins={ 5, 10 }
		amount=6  dp=[0, -1, -1, -1, -1, 1, -1]
		amount=12 dp=[0, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, -1, -1]

	 */
    // _322_零钱兑换
    static int coinChange_(int[] coins,int amount) {
        if (amount < 1 || coins == null || coins.length == 0)
            return -1;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i < coin)
                    continue;
                int v = dp[i - coin];
                System.out.println("i="+i+"  coin="+coin+"  dp["+(i - coin)+"]= "+dp[i - coin]);
                if (v < 0 || v >= min)  //v < 0 即没办法凑；v >= min已经有更优解
                    continue;
                System.out.println("i="+i+"  min="+ v);
                min = v;
            }
            if (min == Integer.MAX_VALUE) {	// 凑不齐,dp[i=-1]
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }


    ///////////////////////////// 动态规划 正解 ////////////////////////////
    /*
        注释版见3_2     假如有coins={5,20}  需要 凑够 20
           1.第一个continue 过滤 凑够1-4
           2.第二个continue 过滤 凑够 6-9 11-14 16-19
              v >= min 继续过滤 凑够15 需要3，但是用20凑够20需要0

    */
    //  dp[n] 凑够n分需要的最少硬币个数
	/*
		// 如果amount数额凑不齐。即：如果没有任何一种硬币组合能组成总金额，返回 -1。
		coins={ 5, 10 }
		amount=6  dp=[0, -1, -1, -1, -1, 1, -1]
		amount=12 dp=[0, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, -1, -1]

	 */
    // _322_零钱兑换
    static int coinChange(int[] coins,int amount) {
        if (amount < 1 || coins == null || coins.length == 0)
            return -1;
        int[] dp = new int[amount + 1];     // dp[n] 凑够n分需要的最少硬币个数
        for (int i = 1; i <= amount; i++) { // 从1开始 可以理解为凑够0分需要0枚硬币。实际上是 20分用20凑够 dp[20-20]需要dp[0]=0
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i < coin)
                    continue;
                int v = dp[i - coin];
                if (v < 0 || v >= min)  //v < 0 即没办法凑；v >= min已经有更优解
                    continue;
                min = v;
            }
            if (min == Integer.MAX_VALUE) {	// 凑不齐,dp[i=-1]
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }

    public static void main(String[] args) {
//        int arr[] = new int[] { 5, 25, 20};
//        int arr[] = new int[] { 2, 5, 10};
        int arr[] = new int[] { 5, 10};
        System.out.println(coinChange(arr,6));
//        Arrays.sort(arr , (a,b) -> a >= b);
//        Arrays.sort(arr, Comparator.reverseOrder());
//        Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder());
//        System.out.println(Arrays.toString(arr));


    }



}
