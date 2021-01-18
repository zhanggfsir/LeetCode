package _88_VIP6.funnyHashMap;

import java.util.HashSet;

/*
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

 
示例 1:

输入: nums = [1,2,3,1], k = 3
输出: true
示例 2:

输入: nums = [1,0,1,1], k = 1
输出: true
示例 3:

输入: nums = [1,2,3,1,2,3], k = 2
输出: false
链接：https://leetcode-cn.com/problems/contains-duplicate-ii


 */
//存在重复元素 II
public class _219_ContainsDuplicateii {

    public static void main(String[] args) {
//        new HashSet<>(5);
//        new HashMap<>(3);
        HashSet<Integer> set = new HashSet<>();
        set.add(4);
        set.add(2);
        set.add(3);
        System.out.println(set);
        int []arr={1,2,3,1,2,3};
        containsNearbyDuplicate(arr,2);
    }

    /*
    这个算法不用hashset也可以啊，也可以用一个queue，加入元素前看queue内有无相同元素，
    如果没有该元素，且queue满的话，再把最早加入的元素pop出来再把该元素加进去。
     这道题并没有用到hashset的不重复性，因为加入元素之前会先判断set里是否有此元素，这个用其他结构都可以实现。
     用hash是利用了hash删除和查找更快的特性吧，毕竟复杂度只有O(1)，用其他结构就会超时。
     */
    /*
        理解重点 ： 1. hashset的大小始终为k。这样当有重复的值时，就确认满足条件了
                   2. 不能 new HashSet<>(5);   这样当Hashset满了之后，会扩容。
     */
    // todo 维护一个滑动窗口大小为k的set，包含即返回T
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {  // set.size < k
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k) {
                set.remove(nums[i - k]);    // set remove 的不是下标，是具体的数.k可以理解为是一个窗口，移除窗口的开始
            }
        }
        return false;
    }
//    维护一个哈希表，里面始终最多包含 k 个元素，当出现重复值时则说明在 k 距离内存在重复元素
//    每次遍历一个元素则将其加入哈希表中，如果哈希表的大小大于 k，则移除最前面的数字
//    时间复杂度：O(n)，n 为数组长度


//    链接：https://leetcode-cn.com/problems/contains-duplicate-ii/solution/hua-jie-suan-fa-219-cun-zai-zhong-fu-yuan-su-ii-by/



    // 暴力求解 ，往往能求解
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]==nums[j]){
                    int kk=Math.abs(i-j);
                    if (kk<=k ){
                        return true;
                    }
                }
            }
        }
        return false;
    }




}
