package _88_VIP6.只出现一次的数字;

import java.util.HashMap;

/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。
找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,3,2]
输出: 3
示例 2:

输入: [0,1,0,1,0,1,99]
输出: 99

 */
public class _137_SingleNumberII {


    class Solution {
        public int singleNumber(int[] nums) {
            HashMap<Integer, Integer> hashmap = new HashMap<>();
            for (int num : nums)
                hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);

            for (int k : hashmap.keySet())
                if (hashmap.get(k) == 1) return k;
            return -1;
        }
    }


// 有一种位运算 有时间 了解一下
//    https://leetcode-cn.com/problems/single-number-ii/solution/zhi-chu-xian-yi-ci-de-shu-zi-ii-by-leetcode/

}
