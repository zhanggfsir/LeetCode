package _88_VIP6.子串问题_dp;

import java.util.Arrays;

/*
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 */
//  longest-increasing-subsequence  最长上升子序列 最长递增子序列
public class _3_300_LIS_最长上升子序列 {



	//_3_300_LIS_最长上升子序列
	/*
		为什么要有  dp[i] = Math.max(dp[i], dp[j] + 1);
		dp[i] 以 nums[i]结尾的最长上升子序列长度
		nums [0,1,0,3,2,3,2]
 		dp   [1,2,1,3,3,4,3]
	 */
	//_3_300_LIS_最长上升子序列
	// dp[i] 以 nums[i]结尾的最长上升子序列长度
	static int lengthOfLIS1_(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		int max = dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {	// 获得dp[i]
				if (nums[i] <= nums[j])
					continue;
				dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			max = Math.max(dp[i], max);
		}
		System.out.println(Arrays.toString(dp));
		return max;
	}
	/*
		dp[i] 以 nums[i]结尾的最长上升子序列长度 前
			1.max=dp[0]=1
			2.当前dp[i]=1; 遍历j<=i得到前j-1个， 如果num[i] <= num[j] continue , dp[i]=max(dp(i),dp(j)+1)
			3.max=max(dp[i],max)
		1.状态初始值
			dp[0]=1
			所有的dp[i]都初始化为1

		2.遍历dp  0 =< j <i
			2.1当num[i]>num[j]
				nums[i]可以拼在num[j]后面，形成一个比dp[j]更长的上升子序列，长度为dp[j]+1
				dp[i] = max{ dp[i],dp[j]+1 }
			2.2当num[i]<num[j]
				num[i]不能拼在num[j]后面，跳过此次遍历continue
		3.max=max(dp[i],max)
		 _53_最大连续子序和   dp[i]的前1个dp[i-1]和0比，每次取出dp[i-1]和0比
		 _300_最长上升子序列  nums[i] 和 num[1~(i-1)]比，
	 */

	/**
	 * 牌顶
	 */
	static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		// 牌堆的数量
		int len = 0;
		// 牌顶数组
		int[] top = new int[nums.length];
		// 遍历所有的牌
		for (int num : nums) {
			int begin = 0;
			int end = len;
			while (begin < end) {
				int mid = (begin + end) >> 1;
				if (num <= top[mid]) {
					end = mid;
				} else {
					begin = mid + 1;
				}
			}
			// 覆盖牌顶
			top[begin] = num;
			// 检查是否要新建一个牌堆
			if (begin == len) len++;
		}
		return len;
	}

	/**
	 * 牌顶
	 */
	static int lengthOfLIS2(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		// 牌堆的数量
		int len = 0;
		// 牌顶数组
		int[] top = new int[nums.length];
		// 遍历所有的牌
		for (int num : nums) {
			int j = 0;
			while (j < len) {
				// 找到一个>=num的牌顶
				if (top[j] >= num) {
					top[j] = num;
					break;
				}
				// 牌顶 < num
				j++;
			}
			if (j == len) { // 新建一个牌堆
				len++;
				top[j] = num;
			}
		}
		return len;
	}

	/**
	 * 动态规划
	 */
	//_3_300_LIS_最长上升子序列
	static int lengthOfLIS1(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		int max = dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {	// 为了获得dp[i]
				if (nums[i] <= nums[j])
					continue;
				System.out.println("before-->"+" dp[i="+i+"]=" +dp[i]+" dp[j="+j+"]=" +dp[j]);
				dp[i] = Math.max(dp[i], dp[j] + 1);
				System.out.println("after-->"+" dp[i="+i+"]=" +dp[i]+" dp[j="+j+"]=" +dp[j]);
			}
			max = Math.max(dp[i], max);
		}
		return max;
	}





	public static void main(String[] args) {
		int []nums={0,1,0,3,2,3,2};
		lengthOfLIS1_(nums);
	}

//	public static void main(String[] args) {
//		System.out.println(lengthOfLIS(new int[] {10, 2, 2, 5, 1, 7, 101, 18}));
//	}
}
