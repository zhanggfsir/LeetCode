package _88_VIP6.子串问题_dp;

/*
给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。

一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。

若这两个字符串没有公共子序列，则返回 0。

 

示例 1:

输入：text1 = "abcde", text2 = "ace"
输出：3
解释：最长公共子序列是 "ace"，它的长度为 3。
示例 2:

输入：text1 = "abc", text2 = "abc"
输出：3
解释：最长公共子序列是 "abc"，它的长度为 3。
示例 3:

输入：text1 = "abc", text2 = "def"
输出：0
解释：两个字符串没有公共子序列，返回 0。
 

提示:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
输入的字符串只含有小写英文字符。

链接：https://leetcode-cn.com/problems/longest-common-subsequence
 */

public class _4_1143_LCS_最长公共子序列 {
	public static void main(String[] args) {
		int len = lcs(new int[] {1, 3, 5, 9, 10}, new int[] {1, 4, 9, 10});
		System.out.println(len);
	}

	/*
		1.dp(i,j) nums1前i个元素 nums2前j个元素的最长公共子序列的长度
		nums1: 1, 3, 5, 9, 10
		nums2: 1, 4, 9, 10
		dp(2,3)=1	nums1前2个元素{1, 3} nums2前3个元素{1, 4, 9}的最长公共子序列的长度
		dp(4,4)=2
		则求解问题变为 dp(num1.length,nums.length).如上为子问题
		dp(i-1,j-1) -> dp(i,j)
	 */
    public int longestCommonSubsequence(String text1, String text2) {
		if (text1 == null || text2 == null) return 0;
		char[] chars1 = text1.toCharArray();  
		if (chars1.length == 0) return 0;
		char[] chars2 = text2.toCharArray();  
		if (chars2.length == 0) return 0;
		char[] rowsChars = chars1, colsChars = chars2;
		if (chars1.length < chars2.length) {
			colsChars = chars1;
			rowsChars = chars2;
		}
		int[] dp = new int[colsChars.length + 1];
		for (int i = 1; i <= rowsChars.length; i++) {
			int cur = 0;
			for (int j = 1; j <= colsChars.length; j++) {
				int leftTop = cur;
				cur = dp[j];
				if (rowsChars[i - 1] == colsChars[j - 1]) {
					dp[j] = leftTop + 1;
				} else {
					dp[j] = Math.max(dp[j], dp[j - 1]);
				}
			}
		}
		return dp[colsChars.length];
    }
	
	static int lcs(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0) return 0;
		if (nums2 == null || nums2.length == 0) return 0;
		int[] rowsNums = nums1, colsNums = nums2;
		if (nums1.length < nums2.length) {
			colsNums = nums1;
			rowsNums = nums2;
		}
		int[] dp = new int[colsNums.length + 1];
		for (int i = 1; i <= rowsNums.length; i++) {
			int cur = 0;
			for (int j = 1; j <= colsNums.length; j++) {
				int leftTop = cur;
				cur = dp[j];
				if (rowsNums[i - 1] == colsNums[j - 1]) {
					dp[j] = leftTop + 1;
				} else {
					dp[j] = Math.max(dp[j], dp[j - 1]);
				}
			}
		}
		return dp[colsNums.length];
	}
	
	static int lcs4(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0) return 0;
		if (nums2 == null || nums2.length == 0) return 0;
		int[] dp = new int[nums2.length + 1];
		for (int i = 1; i <= nums1.length; i++) {
			int cur = 0;
			for (int j = 1; j <= nums2.length; j++) {
				int leftTop = cur;
				cur = dp[j];
				if (nums1[i - 1] == nums2[j - 1]) {
					dp[j] = leftTop + 1;
				} else {
					dp[j] = Math.max(dp[j], dp[j - 1]);
				}
			}
		}
		return dp[nums2.length];
	}


	// 滚动数组 每个格子的值，只是关注 左上 左、上 3个值
	static int lcs3(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0) return 0;
		if (nums2 == null || nums2.length == 0) return 0;
		int[][] dp = new int[2][nums2.length + 1];	// 只对行模除以2 即可
		for (int i = 1; i <= nums1.length; i++) {
			int row = i & 1;	// 位运算1 等价于 int row = i % 2
			int prevRow = (i - 1) & 1;
			for (int j = 1; j <= nums2.length; j++) {
				if (nums1[i - 1] == nums2[j - 1]) {
					dp[row][j] = dp[prevRow][j - 1] + 1;
				} else {
					dp[row][j] = Math.max(dp[prevRow][j], dp[row][j - 1]);
				}
			}
		}
		return dp[nums1.length & 1][nums2.length];
	}

	/*
		1.假设2个序列分别是nums1 nums2
			i [0,nums1.length]
			j [0,nums2.length]
		2.假设dp(i,j)是 (nums1前i个元素)与(nums2前j个元素)的最长公共子序列长度。
		# dp(i,j)是以num1[i-1],nums2[j-1]结尾的最长公共子串的长度。或者说是前i-1 j-1个元素最长公共子序列
			dp(i,0)、dp(0,j)初始值均为0
			如果nums1[i-1]=nums2[j-1],那么dp(i,j)=dp(i-1,j-1)+1
			如果nums1[i-1]!=nums2[j-1],那么dp(i,j)=max{ dp(i-1),(j-1) }
	 */
	//  此方法为准 dp是一个二维数组
	/*
		空间换时间，多了空间的消耗
		空间复杂度 m*n
		时间复杂度 m*n
	 */
	// _4_1143_LCS_最长公共子序列
	static int lcs2(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0)
			return 0;
		if (nums2 == null || nums2.length == 0)
			return 0;

		int[][] dp = new int[nums1.length + 1][nums2.length + 1];
		// i=0 或者j=0 时，dp=0。故，从1开始计算就好
		for (int row = 1; row <= nums1.length; row++) {	// 注意：此处是 <=
			for (int col = 1; col <= nums2.length; col++) {
				if (nums1[row - 1] == nums2[col - 1]) {	//1. nums1 nums2相等  左、上
					dp[row][col] = dp[row - 1][col - 1] + 1;
				} else {							//2. 不相等 上、左
					dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
				}
			}
		}
		// dp[i][j] nums1的前i个元素，即前nums1.length个元素。故dp的长度为nums1.length+1
		return dp[nums1.length][nums2.length];
	}





	/*
		空间复杂度取决于递归深度
		空间复杂度 O(k) k=min{m,n} m、n是2个序列的长度
		时间复杂度 O(2^n) 指数级别增长
	 */
	static int lcs1(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0) return 0;
		if (nums2 == null || nums2.length == 0) return 0;
		return lcs1(nums1, nums1.length, nums2, nums2.length);
	}
	
	/**
	 * 求nums1前i个元素和nums2前j个元素的最长公共子序列长度
	 * @param nums1
	 * @param i
	 * @param nums2
	 * @param j
	 */
	static int lcs1(int[] nums1, int i, int[] nums2, int j) {
		if (i == 0 || j == 0) return 0;
		if (nums1[i - 1] == nums2[j - 1]) {
			return lcs1(nums1, i - 1, nums2, j - 1) + 1;
		}
		return Math.max(lcs1(nums1, i - 1, nums2, j), 
						lcs1(nums1, i, nums2, j - 1));
	}
}
