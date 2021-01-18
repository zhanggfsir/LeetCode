package _88_VIP6.体力活;

/*
给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

示例 1:

输入: [10,2]
输出: 210
示例 2:

输入: [3,30,34,5,9]
输出: 9534330
说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。

 */

import java.util.Arrays;
import java.util.Comparator;

/*
【核心思想】

这道题的核心思想就是构造一个新的比较策略，在这个比较策略下，对数组进行排序，使之组成一个最大的整数
【思路】

先把int数组转化为String数组，方便进行字符串的操作
我们要比较的就是元素a+b和b+a的大小，注意这里的+操作是字符串级别的，并非整数的加
然后我们调用String.compareTo()方法。String类的compareTo()方法是用来比较两个字符串的字典顺序。用字符串1跟字符串2作比较，如果字符串1的字典顺序在字符串2前面，则返回一个负数。
若在后面，则返回一个正数。若两个字符串的字典顺序相同，则返回0(这里的字典顺序同时也反映了int的大小)

 */
public class _179_最大数 {
    public static void main(String[] args) {
        int []arr={3,30,34,5,9};
        largestNumber(arr);
    }
    public  static  String largestNumber(int[] nums) {
        StringBuilder ans = new StringBuilder();
        // 1 int数组转字符串数组
        String[] strs = new String[nums.length];
        for(int i=0;i<nums.length;i++)
            strs[i] = String.valueOf(nums[i]);

        // 2 自定义字符串数组排序
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });

        System.out.println(Arrays.toString(strs));  // [9, 5, 34, 3, 30]

        // 3 字符串数组加入sb
        for(int i=0;i<strs.length;i++)
            ans.append(strs[i]);

        if (ans.charAt(0)=='0')
            return "0";

        return ans.toString();
    }



    public static String PrintMinNumber(int [] nums) {  // int arr[]={3,32,321};
        if(nums == null || nums.length == 0)
            return "";
        int len = nums.length;
        String[] arr = new String[len];             // 1. int数组 转 string数组
        StringBuilder sb = new StringBuilder();
        // 将int[] --> String []
        for(int i = 0; i < len; i++){
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr,new Comparator<String>(){   // 2.Arrays.sort 自定义比较器
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                System.out.println("c1="+c1+"  c2="+c2+"  ->"+c1.compareTo(c2));
                //return c2.compareTo(c1);
                return c2.compareTo(c1);
            }
        });

        System.out.println("-->"+Arrays.toString(arr));     // [321, 32, 3]
        for(int i = 0; i < len; i++){              // 3. 排序后的字符串数组 输出
            System.out.print(arr[i]+" ");
            sb.append(arr[i]);
        }
        System.out.println("==="+sb);  // 321323
        if (sb.charAt(0)=='0'){
            return "0";
        }
        return sb.toString();
    }
    
    
    
    
}
