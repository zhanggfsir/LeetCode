package _88_VIP6.买卖股票;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * @author MJ
 *
 */

/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

注意：你不能在买入股票前卖出股票。

示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
// 122 123 188 714
public class _121_买卖股票的最佳时机 { // 简单

	// dp 求解
	//  如果你最多只允许完成一笔交易（即买入和卖出一支股票一次）
	// _121_买卖股票的最佳时机
    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length == 0) return 0;
    	// 前面扫描过的最小价格
    	int minPrice = prices[0];
    	// 前面扫描过的最大利润
    	int maxProfit = 0;
    	// 扫描所有的价格
    	for (int i = 1; i < prices.length; i++) {	// 每天都是要卖的一天
			if (prices[i] < minPrice) {		// 1. 当前价格，比最小价格还要小。此时，更新最小价格 。且无卖出动作			前面扫描过来，当天最小。没必要卖出，记录前面中[当天]最小值. 【 买入价 】
				minPrice = prices[i];
			} else { // 把第i天的股票卖出	// 2. 其他情况，卖出，获得最大利润
				maxProfit = Math.max(maxProfit, prices[i] - minPrice);
			}
		}
    	return maxProfit;
    }

    // 贪心


}



//  从卖的角度思考
/*
	从后向前 把每一天都当做要卖的那天，算出能获得最大利润的一天
	从后向前 在Z天卖，前面在哪一天能获取最大利润呢
 */


// 看一下 暴力求解