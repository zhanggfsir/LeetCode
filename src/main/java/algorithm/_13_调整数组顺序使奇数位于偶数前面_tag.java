package algorithm;

/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

import java.util.Arrays;

/**
 * 相对位置不变--->保持稳定性；奇数位于前面，偶数位于后面 --->存在判断，挪动元素位置；
 * 偶数 even
 * 奇数 odd
 *
 */
 // 可以和 leetcode 将 两个有序数组 合并为一个有序数组作比较
public class _13_调整数组顺序使奇数位于偶数前面_tag {
    public static void main(String[] args) {
       int a[]= {1,3,2,4,6,7,5,4,2};
        System.out.println(isEven(5));
        reOrderArray3(a);
        System.out.println(Arrays.toString(a)); // [3, 5, 1, 4, 2]

    }
    // todo 方法1  两个队列搞定 Arraylist

    // 方法2
    /*
    方法论 进入一个新数组，只是用来存放偶数！
    2个指针，偶数指针只是用来更新偶数数组；奇数指针只是更新原数组；最后把偶数数组合并到原数组。

    新开数组空间换时间的解法,
    a.遍历数组,如果是奇数从头部放入到原数组中,并记录指针
    b.如果是偶数,放入到新数组中,并记录指针
    c.将新数组的元素安顺序,从最后一个奇数后边插入到原数组中
*/
    public void reOrderArray2(int [] array) {
            int[] even = new int[array.length];  // 偶
            int indexOdd = 0;   // 奇数
            int indexEven = 0;  //偶数
            for (int num : array) {
                if ((num & 1) == 1) {
                    array[indexOdd++] = num;
                } else {
                    even[indexEven++] = num;
                }
            }

            for (int i = 0; i < indexEven; i++) {       // 将偶数数组合并到奇数数组 挺有意思！
                array[indexOdd + i] = even[i];
            }
    }





    /**
     * 1.要想保证原有次序，则只能顺次移动或相邻交换。
     * 2.i从左向右遍历，找到第一个偶数。
     * 3.j从i+1开始向后找，直到找到第一个奇数。
     * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
     * 5.終止條件：j向後遍歷查找失敗。
     */
    public static void reOrderArray3(int [] a) {
        if(a==null||a.length==0)
            return;
        int i = 0,j;    // i 指针指向左边一排奇数的下一个  j指针去寻找偶数
        while(i<a.length){                     //     {1,3,2,4,6,7,5,4,2};
            while(i<a.length && !isEven(a[i])) // 是奇数 奇数范围 [,i-1]
                i++;
            j = i+1;                            // 找到了第一个偶数
            System.out.println(i+"  "+j);      //  2 3                3 4              4 5
            while(j<a.length && isEven(a[j]))   // 所有偶数 范围 [i,j-1]  其中 [j,] 从j开始又是一波奇数
                j++;
//            System.out.println(j);          // 5                    6                9
            if(j<a.length){
                int tmp = a[j];                 //a[j] 是奇数 将奇数往前移动
                for (int j2 = j-1; j2 >=i; j2--) {//将偶数[i,j-1] 整体后移一位，
                    a[j2+1] = a[j2];
                }
                //System.out.println(Arrays.toString(a)); //   [1, 3, 2, 2, 4, 6, 5, 4, 2]
                a[i++] = tmp;                   // 将j放到i的位置     之后while循环基本没有i啥事儿了 i指针指向奇数的下一个位置
                //System.out.println(Arrays.toString(a)); //   [1, 3, 7, 2, 4, 6, 5, 4, 2]
            }else{// 查找失敗
                break;
            }
        }

    }
    static boolean  isEven(int n){ // 判断是偶数
        if(n%2==0)
            return true;
        return false;
    }

    /*
    方法4 以后有时间再研究吧
    看明白了，思想不错

    这些都和内部排序算法相似，考虑到具有稳定性的排序算法不多，例如插入排序，归并排序等；这里采用插入排序的思想实现。
     */
/*
0 0 0 [1, 3, 2, 4, 6, 7, 5, 4, 2]
0 0 0 [1, 3, 2, 4, 6, 7, 5, 4, 2]
1 1 1 [1, 3, 2, 4, 6, 7, 5, 4, 2]
1 1 1 [1, 3, 2, 4, 6, 7, 5, 4, 2]
5 5 2 [1, 3, 2, 4, 6, 7, 5, 4, 2]
5 2 2 [1, 3, 7, 2, 4, 6, 5, 4, 2]
6 6 3 [1, 3, 7, 2, 4, 6, 5, 4, 2]
6 3 3 [1, 3, 7, 5, 2, 4, 6, 4, 2]
[1, 3, 7, 5, 2, 4, 6, 4, 2]
 */
    public static void reOrderArray4(int [] array) {
        //相对位置不变，稳定性
        //插入排序的思想
        int m = array.length;
        int k = 0;//记录已经摆好位置的奇数的个数
        for (int i = 0; i < m; i++) {

            if (array[i] % 2 == 1) {       // 是奇数  第一次遇见偶数m(即 k) 第二次遇见奇数n(即 j) 则中间偶数 [m,n-1
                int j = i;
                System.out.println(i+" "+j+" "+k+" "+Arrays.toString(array));
                while (j > k) {//j >= k+1   // 将右边的一个奇数，一个一个移动右边偶数，移动到左边第一个偶数位置
                    int tmp = array[j];         // j 和 j-1 交换，一直到j--，这样讲读一个不断向前移动
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    j--;
                }
                System.out.println(i+" "+j+" "+k+" "+Arrays.toString(array));
                k++;
            }

        }
    }
}
