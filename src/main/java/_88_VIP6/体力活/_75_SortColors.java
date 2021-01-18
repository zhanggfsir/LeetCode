package _88_VIP6.体力活;

import java.util.Arrays;

/*
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。   // todo 没有次要求，其实就是一个排序问题--
                       1.语言标准库中的排序 Arrays.sort(nums);2.快排。3.计数排序 计数个数有限 统计0 1 2 出现的次数然后分别放入数组 权当 锻炼思维 代码能力了

示例:

输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]

 */
public class _75_SortColors {


    // 此方法为准  使用计数排序
    public static void sortColors3(int[] nums) {
        int count[]=new int[3]; // 存放 0 1 2三个元素的频率
        // 1.统计频率
        for (int i=0;i<nums.length;i++){
            if(nums[i]>2)
                return;
            count[nums[i]]++;   // count[0]=10 即  下标0出现了10次
        }

        // 2.将相应元素放入数组
//        int index=0;        // 依次放入数组，数组的下标
//        for (int i = 0; i < count[0]; i++) {  // count[0]=10 即  下标0出现了10次
//            nums[index++]=0;                   // 将nums 对应index下标置为0
//        }
//        for (int i = 0; i < count[1]; i++) {
//            nums[index++]=1;                    // 将nums 对应index下标置为0
//        }
//        for (int i = 0; i < count[2]; i++) {
//            nums[index++]=2;                    // 将nums 对应index下标置为0
//        }

        // 如下代码可以替换如上代码
        for (int i = 0,j=0; i <3 ; i++) {
            while (count[i]-->0){  // count[0]=10  0出现了10次
                nums[j++]=i;        // 将num[j] 的j下标的值 用i赋值
            }
        }

    }

    public static void main(String[] args) {
        int arr[]={2,0,2,1,1,0};
        sortColors3(arr);
        System.out.println(Arrays.toString(arr));
    }



    //  TODO 荷兰国旗问题 dutch  national flag problem
/*
复杂度分析

时间复杂度 :由于对长度 NN的数组进行了一次遍历，时间复杂度为O(N)O(N) 。

空间复杂度 :由于只使用了常数空间，空间复杂度为O(1)O(1) 。
_75_SortColors */

    /*
    此思想也不错  详解见 tmd_01  三指针
    荷兰三色旗问题解

    三个指针（p0, p2 和curr）来分别追踪 0的最右边界，2的最左边界和当前考虑的元素。
    2 0 2 1 1 0
    发现是0放到最左边

    本解法的思路是沿着数组移动 curr 指针，若nums[curr] = 0，则将其与 nums[p0]互换；若 nums[curr] = 2 ，则与 nums[p2]互换。

    */
    public void sortColors(int[] nums) {
//        Arrays.sort(nums);
        // 对于所有 idx < i : nums[idx < i] = 0
        // j是当前考虑元素的下标
        int p0 = 0, curr = 0;
        // 对于所有 idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 交换第 p0个和第curr个元素
                // i++，j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }
            else if (nums[curr] == 2) {
                // 交换第k个和第curr个元素
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            }
            else curr++;
        }
    }



}
