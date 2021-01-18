package _08_highFrequency;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 */
/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。

链接：https://leetcode-cn.com/problems/move-zeroes
 */
public class _283_移动零 {

    public void moveZeroes(int[] nums) {
        if (nums == null)
            return;
        for (int i = 0, cur = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                continue;
            if (cur != i) {
                nums[cur] = nums[i];
                nums[i] = 0;
            }
            cur++;
        }
    }

    //  快慢指针 yeah
    public void moveZeroes2(int[] nums) {
        int i=0;
        for (int j = 0; j <nums.length ; j++) {
            if (nums[j]!=0){
                nums[i++]=nums[j];
            }
        }
        for (int j = i; j < nums.length; j++) {
            nums[j]=0;
        }
    }

    }

