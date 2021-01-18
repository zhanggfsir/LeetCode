package _88_VIP6.子串问题_dp.编辑距离;


/*
给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符

示例 1：
输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')

示例 2：
输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')


 */
// 困难  特别经典
//  编辑距离算法被数据科学家广泛应用，是用作机器翻译和语音识别评价标准的基本算法。

/*
s1[0,i) 是由s1的前i个字符组成的子串。 取值范围是:[0,i-1]。	示例： s[0,2) 包含的字符为s[0] s[1]
s2[0,j] 是由s2的前j个字符组成的子串。
dp是大小为(n1+1)*(n2+1)的二维数组。
dp[i][j] 是s1[0,i]转换成s2[0,j]的最小操作数。   示例： dp[2][3]   s[0,2)转换成s2[0,3)的最小操作数

dp[n1][n2]就是要的答案，即s1[0,n1]转换成s2[0,n2]的最小操作数。即s1转换成s2的最小操作数

1.dp[0][0]代表s1的空子串转换成s2的空子串的最小操作数
其实就是什么都不做，所以dp[0][0]=0

2.第0列的dp[i][0] 代表s1[0,i)转换成s2的空子串的最小操作数
其实即使删除s1[0,i)的所有字符，所以dp[i][0]=i

3.第0行的dp[0][j] 代表s1的空子串转换为s2[0,j)的最小操作数
其实就是插入s2[0,j)的所有字符，所以dp[0][j]=j

4.如何求dp[i][j]
  4.1 如果s1[i-1]!=s2[j-1] dp[i][j]=dp[i-1][j-1]+1
  4.2 如果s1[i-1] =s2[j-1] dp[i-1][j-1]
 */
public class _72_编辑距离 {  // 困难
	public int minDistance(String word1, String word2) {
		if (word1 == null || word2 == null)
			return 0;
		char[] cs1 = word1.toCharArray();
		char[] cs2 = word2.toCharArray();
		int[][] dp = new int[cs1.length + 1][cs2.length + 1];
		// 00
		dp[0][0] = 0;
		// 第0列
		for (int i = 1; i <= cs1.length; i++) {
			dp[i][0] = i;
		}
		// 第0行
		for (int j = 1; j <= cs2.length; j++) {
			dp[0][j] = j;
		}
		// 其他行其他列
		for (int i = 1; i <= cs1.length; i++) {		// 状态定义 状态转移方程
			for (int j = 1; j <= cs2.length; j++) {
				int top = dp[i - 1][j] + 1;	    // top取上   当前值上边那一行的值
				int left = dp[i][j - 1] + 1;    // left取左   当前值左边那一列的值
				int leftTop = dp[i - 1][j - 1]; // leftTop取左上 上边那一行，左边那一列
				if (cs1[i - 1] != cs2[j - 1]) {	// 左上的值是否需要+1 : 当左上对应的s1 != s2时+1
					leftTop++;
				}
				dp[i][j] = Math.min(Math.min(top, left), leftTop);
			}
		}
		return dp[cs1.length][cs2.length];
	}
}
