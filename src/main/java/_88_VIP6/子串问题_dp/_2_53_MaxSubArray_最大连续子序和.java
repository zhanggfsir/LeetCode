package _88_VIP6.子串问题_dp;

import java.util.Arrays;

/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:
输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

 */
public class _2_53_MaxSubArray_最大连续子序和 {
	public static void main(String[] args) {
		System.out.println(maxSubArray1(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}

	/*
    时间复杂度 n
    空间复杂度 1
    dp[i] 是以nums[i]结尾的最大连续子序列和

    dp[i]只关注 dp[i-1]

   最大切片 greatest slice

	子序列 : 可以不连续
	子串、子数组、子区间 : 必须连续
 	*/
	// _53_MaxSubArray_最大子序和
	static int maxSubArray2(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int dp = nums[0];
		int max = dp;
		for (int i = 1; i < nums.length; i++) {
			if (dp <= 0) {
				dp = nums[i];
			} else {
				dp = dp + nums[i];
			}
			max = Math.max(dp, max);
		}
		return max;
	}

	/*
		时间复杂度 n
		空间复杂度 n

		dp[i] 是以nums[i]结尾的最大连续子序列和
			1.max=dp[0]=nums[0]
			2.前1个 dp[i-1] 和0比较； <=0 dp[i] = nums[i],>0 dp[i] = dp[i-1] + nums[i];
			3.max=max(dp[i],max)

		状态转移方程
			如果dp[i-1]<=0,那么dp[i]=num[i]
			如果dp[i-1]>0, 那么dp[i]=dp[i-1]+num[i]
		初始状态
			dp[0]的值是nums[0]
		最终的解
			最大连续子序和是所有dp[i]中的最大值max{dp[i]}		0 <= i <= nums.length
	 */
	// _53_MaxSubArray_最大子序和
	// dp[i] 是以nums[i]结尾的最大连续子序列和
	// nums {-2,1,-3,4,-1,2,1,-5,4}
	// dp   {-2,1,-2,4, 3,5,6, 1,5}
	// max
	static int maxSubArray1(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		//dp[0] = nums[0];
		int max = dp[0] = nums[0];
		for (int i = 1; i < dp.length; i++) {
			int prev = dp[i - 1];
			if (prev <= 0) {	// dp[i-1] <= 0					// dp[i-1] 以i-1位置结尾的最大连续子序和是负数，拖后腿
				dp[i] = nums[i];
			} else {			// dp[i]    > 0
				dp[i] = prev + nums[i];
			}
			max = Math.max(dp[i], max);
		}
		System.out.println(Arrays.toString(dp));
		return max;
	}


	// 最大子序和  [-2,1,-3,4,-1,2,1,-5,4] ->
	// 连续子数组 [4,-1,2,1] 的和最大，为 6。
	// 53 最大子序和
	public int maxSubArray_(int[] nums) {
		int ans = nums[0]; // 可能第一个就是答案
		int sum = 0;
		for(int num: nums) {
			if(sum + num > num) {  // if(sum > 0)
				sum += num;  // sum = sum + num
			} else {
				sum = num;
			}
			ans = Math.max(ans, sum);
		}
		return ans;
	}


//https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
//https://leetcode-cn.com/problems/maximum-subarray/solution/zheng-li-yi-xia-kan-de-dong-de-da-an-by-lizhiqiang/
/*

这道题用动态规划的思路并不难解决，比较难的是后文提出的用分治法求解，但由于其不是最优解法，所以先不列出来
动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
时间复杂度：O(n)O(n)



真的是太强了，我看的时候看不懂，自己动笔写了一列数才看懂ans和sum之间的关系。
ans存储最大值，sum只管往后加，变成负数就不继续加了，转而指向下一个数，然后重复同样的步骤往后加。太妙了这想法。

@Outstanding 当前sum值小于0，不管num是正数还是负数，sum+num都会减小，
所以sum<0时，更新sum=num使sum更大


@戰龍小宏 将每一个数取在num 第一次放在 sum中， 后面比较sum是否大于0 ，
大于0 就接着加上去。小于0 就说明加上去 还比之前小了，就不加了呗，
直到找到下一个大于0的才接着加。 如果全负数 ，就等于挨个比较谁最大

 */



}
