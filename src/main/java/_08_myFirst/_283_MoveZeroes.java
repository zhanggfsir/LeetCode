package _08_highFrequency;

import java.util.Arrays;

/*

给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组【这个条件 很苛刻】。
尽量减少操作次数。
 */
public class _283_MoveZeroes {

    // TODO   还有几种方法 可以消化一下
    /*
    我们创建两个指针i和j，第一次遍历的时候指针j用来记录当前有多少非0元素。即遍历的时候每遇到一个非0元素就将其往数组左边挪，第一次遍历完后，j指针的下标就指向了最后一个非0元素下标。
第二次遍历的时候，起始位置就从j开始到结束，将剩下的这段区域内的元素全部置为0。
动画演示：

     */
    //  todo 此方法为准 但是 时间复杂度是 O(n)  空间复杂度也是 O(1) 没有使用额外的数组 !!!!!!!!!!!!

    public void moveZeroes(int[] nums) {
        if(nums==null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int i = 0;
        for(int j=0;j<nums.length;++j) {
            if(nums[j]!=0) {
                nums[i++] = nums[j];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for(int j=i;j<nums.length;++j) {
            nums[j] = 0;
        }
    }



    // 如果没有条件 -- “必须在原数组上操作，不能拷贝额外的数组【这个条件 很苛刻】。”
//    声明第三个数组 例如
    //  todo 但是 时间复杂度是 O(n)  空间复杂度也是 O(n)
    public void moveZeroes_0(int[] nums) {
        int []arrAnother=new int[nums.length];
        int jAnother=0;
        for (int i=0;i<nums.length;i++){ // 1 把不为0的元素放入 另一个数组
            if(nums[i]!=0){
                arrAnother[jAnother]=nums[i];
                jAnother++;
            }
        }
        for (int i=0;i<arrAnother.length;i++){  // 将所有arrAnother的元素放回 arr
            nums[i]=arrAnother[i];
        }
        for (int i=arrAnother.length;i<nums.length;i++){ // 将所有 arr剩下的元素赋值为0就好了
            nums[i]=0;
        }

    }



    // todo 当看第二次的时候 容易理解了
    public  static void moveZeroes2_2(int[] nums) {
        if(nums==null) {
            return;
        }
        //两个指针i和j           {4,2,0,1,5,0,3,12}  快指针i一直跑，慢指针j
        int i = 0;
        for(int j=0;j<nums.length;j++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[j]!=0) {    //  swap(i++,i) // 将j 和 i位置元素交换，并将j++
                int tmp = nums[j];
                nums[j] = nums[i];  // 前2个不为0 将nums[0] 和 nums[0]交换
                nums[i++] = tmp;
            }
        }
    }
    /*
     *这里参考了快速排序的思想，快速排序首先要确定一个待分割的元素做中间点x，然后把所有小于等于x的元素放到x的左边，大于x的元素放到其右边。
这里我们可以用0当做这个中间点，把不等于0(注意题目没说不能有负数)的放到中间点的左边，等于0的放到其右边。
这的中间点就是0本身，所以实现起来比快速排序简单很多，我们使用两个指针i和j，只要nums[i]!=0，我们就交换nums[i]和nums[j]

个人分析，这个方法很经典
不好分析 不看也罢...
*
     */
    // todo  方法一 是需要将 最后需要为0的元素全部置为0 方法二直接是把所有0元素移动到了最后，置0的过程省略了 .
    //  将非0元素和0元素交换位置达到效果


    public  static void moveZeroes2(int[] nums) {
        if(nums==null) {
            return;
        }
        //两个指针i和j           {4,2,0,1,5,0,3,12}  快指针i一直跑，慢指针j
        int j = 0;   // i 快指针一直向后跑，j 慢指针 1.当没有0时，i j 一起跑；当有0时i去找到的永远是第一个不为0的数，j指向当前为0的第一个数[第一个0]
        for(int i=0;i<nums.length;i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[i]!=0) {         //  swap(j++,i) // 将j 和 i位置元素交换，并将j++
                System.out.print("nums["+i+"]="+nums[i]+"  "+"nums["+j+"]="+nums[j]+"   after:");
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
                System.out.println("nums["+i+"]="+nums[i]+"  "+tmp+"  "+"nums["+j+"]="+nums[j] +" "+ Arrays.toString(nums));
            }
        }
    }

/*
nums[0]=4  nums[0]=4   after:nums[0]=4  4  nums[1]=2 [4, 2, 0, 1, 5, 0, 3, 12]
nums[1]=2  nums[1]=2   after:nums[1]=2  2  nums[2]=0 [4, 2, 0, 1, 5, 0, 3, 12]
nums[3]=1  nums[2]=0   after:nums[3]=0  1  nums[3]=0 [4, 2, 1, 0, 5, 0, 3, 12]
nums[4]=5  nums[3]=0   after:nums[4]=0  5  nums[4]=0 [4, 2, 1, 5, 0, 0, 3, 12]
nums[6]=3  nums[4]=0   after:nums[6]=0  3  nums[5]=0 [4, 2, 1, 5, 3, 0, 0, 12]
nums[7]=12  nums[5]=0   after:nums[7]=0  12  nums[6]=0 [4, 2, 1, 5, 3, 12, 0, 0]
[4, 2, 1, 5, 3, 12, 0, 0]

 */

    public static void main(String[] args) {
        int arr[]={4,2,0,1,5,0,3,12};
        moveZeroes2(arr);
        System.out.println(Arrays.toString(arr));
    }

}
