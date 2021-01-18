package _88_VIP6.funnyHashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class _1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) return null;
        // 用来存放之前扫描过的元素
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(target - nums[i]);
            if (value != null)
                return new int[]{value, i};
            map.put(nums[i], i);
        }
        return null;
    }
}
