package my_leetcode._1_fast_slow_point;

/*
给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

示例 1:
给定数组 nums = [1,1,2],
]
函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
你不需要考虑数组中超出新长度后面的元素。

示例 2:
给定 nums = [0,0,1,1,1,2,2,3,3,4],
函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
你不需要考虑数组中超出新长度后面的元素。

 */

import java.util.Arrays;

/*
方法：双指针法
算法

数组完成排序后，我们可以放置两个指针 ii 和 jj，其中 ii 是慢指针，而 jj 是快指针。
只要 nums[i]=nums[j]，我们就增加 jj 以跳过重复项。

当我们遇到 nums[j]!=nums[i] 时，跳过重复项的运行已经结束，因此我们必须把它（nums[j]nums[j]）的值
 复制到 nums[i + 1]nums[i+1]。然后递增 ii，接着我们将再次重复相同的过程，
 直到 jj 到达数组的末尾为止。


 */
// _26_删除排序数组中的重复项 有序数组去重
public class _26_RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int arr[]={2,2,3,3,3,4,5,6,6,7};
        int i=removeDuplicates(arr);
        System.out.println(i);
        System.out.println(Arrays.toString(arr));
    }

    //  todo  目前仅此处是 ++i
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0)
            return 0;
        int i = 0;
        for (int j = 1; j < arr.length; j++) { // 慢指针 i 从0开始；快指针j 从1开始
            if (arr[j] != arr[i]) {// 当满足条件时，i++  i 是慢指针 j 是快指针  // todo i下标是排序好的
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;  // i 为下标 要返回数组的长度 +1
    }

}
