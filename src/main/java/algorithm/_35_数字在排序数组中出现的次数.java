package algorithm;

import java.util.Arrays;

/*
统计一个数字在排序数组中出现的次数。
 */
public class _35_数字在排序数组中出现的次数 {

    public static void main(String[] args) {
        // python 解法
//        return data.count(k)
    }
    /*
   一个简单到爆炸的解法  感觉有点儿嘻嘻哈哈  不正经儿
     */

    public int GetNumberOfK1(int [] array , int k) {
        int count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==k)
                count++;
        }
        return count;
    }





//    二分查找，参考剑指Offer,但是用的非递归。

    public class Solution {
        public int GetNumberOfK(int[] array, int k) {
            if (array == null || array.length == 0)
                return 0;
            int first = getFirstK(array, k, 0, array.length - 1);
            int last = getLastK(array, k, 0, array.length - 1);
            if (first == -1 || last == -1) {
                return 0;
            } else {
                return last - first + 1;
            }

        }

        public int getFirstK(int[] array, int k, int start, int end) {
            while (start <= end) {
                int mid = (start + end) / 2;
                if (k < array[mid])
                    end = mid - 1;
                else if (k > array[mid])
                    start = mid + 1;
                else {  // 这其实是找到了 target
                    if ((mid > 0 && array[mid - 1] != k) || mid == 0) // 什么时间返回 mid
                        return mid;
                    else {
                        end = mid - 1;  // 什么时间mid值指针移动
                    }
                }
            }
            return -1;
        }

        public int getLastK(int[] array, int k, int start, int end) {
            while (start <= end) {
                int mid = (start + end) / 2;
                if (k < array[mid])
                    end = mid - 1;
                else if (k > array[mid])
                    start = mid + 1;
                else {    // 这其实是找到了 target
                    if ((mid < array.length - 1 && array[mid + 1] != k) || mid == array.length - 1)
                        return mid;
                    else {
                        start = mid + 1;
                    }
                }
            }
            return -1;
        }
    }





    /*
     看见有序，肯定就是二分查找了，算法比较简单，不多说，值得一提的是，不要拘泥于递归，要会循环写法。
    方法论：找到该数字在数组中第一次、最后一次出现的位置，然后作差
     */
    public int GetNumberOfK(int [] array , int k) {
        int length = array.length;
        if(length == 0){
            return 0;
        }
        int firstK = getFirstK(array, k, 0, length-1);
        int lastK = getLastK(array, k, 0, length-1);
        if(firstK != -1 && lastK != -1){
            return lastK - firstK + 1;
        }
        return 0;
    }


    //递归写法
    private int getFirstK(int [] array , int k, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end) >> 1;
        if(array[mid] > k){
            return getFirstK(array, k, start, mid-1);
        }else if (array[mid] < k){
            return getFirstK(array, k, mid+1, end);
        }else if(mid-1 >=0 && array[mid-1] == k){
            return getFirstK(array, k, start, mid-1);
        }else{
            return mid;
        }
    }
    //循环写法
    private int getLastK(int [] array , int k, int start, int end){
        int length = array.length;
        int mid = (start + end) >> 1;
        while(start <= end){
            if(array[mid] > k){
                end = mid-1;
            }else if(array[mid] < k){
                start = mid+1;
            }else if(mid+1 < length && array[mid+1] == k){
                start = mid+1;
            }else{
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }




}
