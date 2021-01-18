package _88_VIP6.交集;

import java.util.HashMap;
import java.util.LinkedList;

/*
350. 两个数组的交集 II

给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]

示例 2:
输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]
说明：

输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
我们可以不考虑输出结果的顺序。
进阶:

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？

 */
public class _350_IntersectionofTwoArraysII {

    /*
    发现HashMap真是好用，哈哈哈
    //先用Hashmap记录第一个数组中的元素【放在key】，和出现的次数【放在value】。
    然后再遍历第二个数组，如果找到对用元素&&对应HashMap中的value不为0，则添加这个元素到list中等下放到数组中，
    同时，HashMap中的value值减一，表示已经找到一个相同的了。最后的话，将list中的值取出来，放到数组中返回

    使用哈希表记录数组1中的数和其对应频次。
    遍历数组2，如果当前索引的数在哈希表中存在，则把它丢进结果list中，并把它在哈希表中的频次-1，如果频次为0就移除它。
    完成遍历后，list中就是我们希望得到的结果。


     */
 //            if(map.containsKey(arr1[i]))
//                map.put(arr1[i], map.get(arr1[i]) + 1);
//            else
//                map.put(arr1[i], 1);

    //  两个数组的交集 II
    public int[] intersect(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        //先遍历第一个数组，并初始化map
        for(int i = 0; i < arr1.length; i++){
            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
        }

        //再遍历第二个数组，将于map中找到的key放入list中
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int j = 0; j < arr2.length; j++){
            if(map.containsKey(arr2[j]) && map.get(arr2[j]) > 0){  // 关键2 由于下面进行了 -1 ，那么可能导致(k,0)的情况，此时不能进行计次
                list.add(arr2[j]); //添加到list中
                map.put(arr2[j], map.get(arr2[j]) - 1);  // 关键，因为需要的是重复的，计次-1
            }
        }

        //最后，将list中的值放入数组中
        int count = list.size();
        int[] aux = new int[count]; // aux 辅助
        for(int i = 0; i < count; i++){
            aux[i] = list.poll();
        }
        return aux;
    }


//    public int[] intersect(int[] arr1, int[] arr2) {
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();.
//        //先遍历第一个数组，并初始化map
//        for(int i = 0; i < arr1.length; i++){
//            if(map.containsKey(arr1[i]))
//                map.put(arr1[i], map.get(arr1[i]) + 1);
//            else
//                map.put(arr1[i], 1);
//        }
//
//        //再遍历第二个数组，将于map中找到的key放入list中
//        LinkedList<Integer> list = new LinkedList<Integer>();
//        for(int j = 0; j < arr2.length; j++){
//            if(map.containsKey(arr2[j]) && map.get(arr2[j]) > 0){  // 关键2 由于下面进行了 -1 ，那么可能导致(k,0)的情况，此时不能进行计次
//                list.add(arr2[j]); //添加到list中
//                map.put(arr2[j], map.get(arr2[j]) - 1);  // 关键，因为需要的是重复的，计次-1
//            }
//        }
//
//        //最后，将list中的值放入数组中
//        int count = list.size();
//        int[] aux = new int[count]; // aux 辅助
//        for(int i = 0; i < count; i++){
//            aux[i] = list.poll();
//        }
//        return aux;
//    }


}
