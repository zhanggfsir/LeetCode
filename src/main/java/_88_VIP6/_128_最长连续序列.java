package _88_VIP6;

/*
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？

示例 1：
输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。

示例 2：
输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9

 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//_128_最长连续序列 hard
public class _128_最长连续序列 {


    /*
    准备一个set,首先将所有的num装进set
    for loop 数组，如果当前遍历到的元素num−1不在set中，说明这是一段新的可能出现的递增序列，
                   变量curNum置为num，while循环判断curNum+1是否在set中，是则表示是连续的
    记录max值

       */
    // _128_最长连续序列
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        int max = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {//一个新的连续序列 。 判断set不包含当前元素-1的值，跳过已经计算的最长递增序列
                int curNum = num;
                int curCnt = 1;
                while (set.contains(curNum + 1)) {
                    curNum += 1;
                    curCnt += 1;
                }
                max = Math.max(max,curCnt);
            }
        }
        return max;
    }


    // O(n) set已经去重












    /*
    方法:Sort+Compare
           先排序，题意要求连续序列，即可以比较nums[i] 与 nums[i - 1]，如果不相等，表示是递增的趋势，相等则反之，递增后需要判断是否连续，即相邻的元素差值是否为11
           下面的代码处理边界case 如[-1,0],不会比较max与cur的值，需要在最后一道防线拦截一次
     */
    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int max = 1, cur = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i - 1] + 1 == nums[i]) cur++;
                else {
                    max = Math.max(max, cur);
                    cur = 1;
                }
            }
        }
        return Math.max(max, cur);
    }
//    复杂度分析
//    时间复杂度：O(Nlog(N))，N是数组的长度，排序的复杂度
//    空间复杂度：O(1)，常量级别的空间

//    链接：https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/dong-tai-gui-hua-jie-zui-chang-zi-xu-lie-zi-chua-5/



}
