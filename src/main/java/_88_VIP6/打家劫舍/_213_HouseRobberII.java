package _88_VIP6.打家劫舍;

import java.util.Arrays;

/*
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。

 

示例 1：

输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2：

输入：nums = [1,2,3,1]
输出：4
解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 3：

输入：nums = [0]
输出：0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/house-robber-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
// _213_打家劫舍  动态规划
public class _213_HouseRobberII {

    // 是 198. 打家劫舍 的变形。将一个大问题拆解为2个子问题。
    // 数组下标 0 和 (n-1)相邻，不能同时偷。则求解为 max{  arr[0,(n-2)] , arr[1~(n-1)]  }
    // 示例 {2,7,9,3,1} 由于 arr[0]=2 arr[n-1]=1 不能同时偷，
    //      则 {2,7,9,3} {7,9,3,1} 两个数组中求最大值
    public static int rob(int[] nums) {

        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        if (nums.length==2) return Math.max(nums[0],nums[1]);

        int[] subArr1= Arrays.copyOfRange(nums,0,nums.length-1); // [2, 7, 9, 3]
        int[] subArr2= Arrays.copyOfRange(nums,1,nums.length); // [7, 9, 3, 1]

        int res1=rob198(subArr1);
        int res2=rob198(subArr2);
        return Math.max(res1,res2);

    }


    // 198. 打家劫舍 dp 解法
    // array[3]是从第3号房子开始往前偷出来的最大金额
    // array[i]是从第i号房子开始往前偷出来的最大金额
    public  static int rob198(int[] nums){
        if(nums==null || nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];

        int [] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i]=Math.max(nums[i] + dp[i-2] , dp[i-1]);
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] arr={2,7,9,3,1};
        rob(arr);
    }
}
