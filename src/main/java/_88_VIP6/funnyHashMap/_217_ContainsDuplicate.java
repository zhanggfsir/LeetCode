package _88_VIP6.funnyHashMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
给定一个整数数组，判断是否存在重复元素。
如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。

示例 1:
输入: [1,2,3,1]
输出: true

示例 2:
输入: [1,2,3,4]
输出: false

示例 3:
输入: [1,1,1,3,3,4,3,2,4,2]
输出: true

 */
public class  _217_ContainsDuplicate {
    // _217_重复元素
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x))
                return true;
            set.add(x); // else
        }
        return false;
    }

    /*
时间复杂度 : O(n \log n)O(nlogn)。
排序的复杂度是 O(n \log n)O(nlogn)，扫描的复杂度是 O(n)O(n)。整个算法主要由排序过程决定，因此是 O(n \log n)O(nlogn)。

空间复杂度 : O(1)O(1)。
这取决于具体的排序算法实现，通常而言，使用 堆排序 的话，是 O(1)O(1)。

     */

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }
}
