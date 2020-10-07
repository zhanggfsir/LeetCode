package algorithm;

import java.util.ArrayList;
import java.util.HashMap;

/*
输入一个递增排序的数组 和 一个数字S，在数组中查找两个数，使得他们的和正好是S，
如果有多对数字的和等于S，输出两个数的乘积最小的。

对应每个测试案例，输出两个数，小的先输出。
 */
public class _42_和为S的两个数字 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        FindNumbersWithSum(arr,12);
    }

    public ArrayList FindNumbersWithSum_2(int[] array, int sum) {
        HashMap map = new HashMap();
        ArrayList result = new ArrayList();
        int len = array.length;
        for (int i = 0; i < len; i++) {
            map.put(array[i], i);
        }
        for (int i = 0; i < len; i++) {
            int sub = sum - array[i];
            if (map.containsKey(sub)) {
                result.add(array[i]);
                result.add(sub);
                break;
            }
        }
        return result;
    }




    /*
    解读 题中说的：输出两个数的乘积最小的。其实就是取出第一个组满足条件的
     */

    /*
    方法论
    2个指针 左右夹逼

     // 既然是排序好的，就好办了：左右加逼
    // 多组满足的条件下的输出:乘积最小的肯定是第一组

左右夹逼法！！！只需要2个指针
1.left开头，right指向结尾
2.如果和小于sum，说明太小了，left右移寻找更大的数
3.如果和大于sum，说明太大了，right左移寻找更小的数
4.和相等，把left和right的数返回

如果想证明的话
若b>a,且存在，
a + b = s;
(a - m ) + (b + m) = s
则：(a - m )(b + m)=ab - (b-a)m - m*m < ab；说明外层的乘积更小
     */

    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length == 0)
            return list;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int total = array[left] + array[right];
            if (total == sum) {
                list.add(array[left]);
                list.add(array[right]);
                return list;
            } else if (total > sum) {
                //大于sum，说明太大了，right左移寻找更小的数
                --right;

            } else {
                //2.如果和小于sum，说明太小了，left右移寻找更大的数
                ++left;
            }
        }
        return list;
    }



// 哈哈哈哈 还有一个冒泡....

}