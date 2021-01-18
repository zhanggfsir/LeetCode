package my_leetcode._5_container_;

import java.util.*;

/*
349. 两个数组的交集

给定两个数组，编写一个函数来计算它们的交集。 

示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
 

说明：

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。

 */
public class _349_IntersectionofTwoArrays {

    public static void main(String[] args) {
        int []nums1 = {4,9,5};int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));;
    }

    /*
    1.set 中元素时唯一的
    2.遍历n1，加入set1；遍历n2，set1.contains(n2[xx]), 然后把 n2[xx]加入到不同容器罢了
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();//如果数据量大，应当考虑TreeSet
        for (Integer n : nums1)
            set1.add(n);
        List<Integer> list = new ArrayList<Integer>();

        for (Integer n : nums2) {
            if(set1.contains(n)){
                list.add(n);
                set1.remove(n);  // 记得 remove
            }
        }
        int[] output =new int[list.size()];  // 以下代码单纯是为了 把list中的数据拷贝到数组
        for(int i=0;i<list.size();i++){
            output[i]=list.get(i);
        }
        return output;
    }


    public int[] intersection2(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0;i < nums1.length;i++) {
            if(!set.contains(nums1[i])) {
                set.add(nums1[i]);
            }
        }

        for(int i = 0;i < nums2.length;i++) {
            if(set.contains(nums2[i])) { // 和方法1 雷同，依然是 set1.contains(n2[xx]), 然后把 n2[xx]加入到不同容器罢了
                set2.add(nums2[i]);
            }
        }

        Iterator<Integer> it = set2.iterator();
        while(it.hasNext()) {
            queue.offer(it.next());
        }
        int size = queue.size();
        int[] arr = new int[size];
        for(int i = 0;i < size;i++) {
            arr[i] = queue.poll();
        }
        return arr;
    }

}
