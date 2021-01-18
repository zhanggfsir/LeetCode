package _88_VIP6.买卖股票;

/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 

示例 1:

输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
示例 2:

输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
示例 3:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii

 */
//  122. 买卖股票的最佳时机 II
//  有个隐性前提 当天可以卖了当天可以买
//  这个叫做t，先买后卖叫正t，先卖后买叫负t，一般我都做正t
///  每天都在赚（差价）利润，赚取相邻两天的差价
//  贪心 只考虑当日最优，累计成为全局最优~~
//  你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
//  最大获利，把每天的获利都加起来就好了，
public class _122_买卖股票最佳时机II_贪心 {

    //  等价于每天都买卖
    public int maxProfit_(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0)
                profit += tmp;
        }
        return profit;
    }


    // 贪心求解
    // 遍历一次，只要当前价格大于前一天价格，就锁定利润，加起来
    // _122_买卖股票最佳时机II_贪心
    public static int maxProfit(int []price){
        int maxProfit=0;
        for (int i = 1; i < price.length; i++) {
            if (price[i] > price[i-1]){
                maxProfit+=price[i]-price[i-1];
            }
        }
        return maxProfit;
    }

    public static int maxProfit__(int []price){
        int maxProfit=0;
        for (int i = 1; i < price.length; i++) {
            if (price[i] > price[i-1]){
                System.out.println("   i="+i+"   i-1="+(i-1));
                maxProfit+=price[i]-price[i-1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int [] arr={7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}
