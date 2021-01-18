package my_leetcode._4_heap_topK;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//451. 根据字符出现频率排序
/*
给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

示例 1:
输入:
"tree"
输出:
"eert"

解释:
'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。

示例 2:
输入:
"cccaaa"
输出:
"cccaaa"

解释:
'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。

示例 3:
输入:
"Aabb"

输出:
"bbAa"

解释:
此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
注意'A'和'a'被认为是两种不同的字符。

 */
public class _451_SortCharactersByFrequency_没考过 {
    public static void main(String[] args) {
        String s="tree"; // 第一步也是将ss转为   s.toCharArray()

        frequencySort(s);
        System.out.println(frequencySort(s));
        System.out.println("---------------");
        System.out.println(frequencySort_(s));
    }
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

//        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
//                (e1, e2) -> e2.getValue() - e1.getValue());

        //  大顶堆 求K个最小。节点最大
        PriorityQueue<Character> q=new PriorityQueue<>((e1,e2)->map.get(e2)-map.get(e1));
        for (char c:map.keySet()){
            q.add(c);
            if(q.size()>2){
                q.poll();
            }
        }
//        q.add(map.keySet());  // 不行

        StringBuilder sb = new StringBuilder(s.length());  // 这样不行
        while (!q.isEmpty()) {
            char c = q.poll();
            for (int i = 0; i < map.get(c); i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }



        public  static String frequencySort_(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (char chr : s.toCharArray()) {
                map.put(chr, map.getOrDefault(chr, 0) + 1);
            }

            PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                    (e1, e2) -> e2.getValue() - e1.getValue());

            maxHeap.addAll(map.entrySet());

            StringBuilder sb = new StringBuilder(s.length());
            while (!maxHeap.isEmpty()) {
                Map.Entry<Character, Integer> entry = maxHeap.poll();
                for (int i = 0; i < entry.getValue(); i++){
                    sb.append(entry.getKey());
                }
            }
            return sb.toString();
        }
//    time: worst case，因为没有重复元素，每一个都是唯一的，那么O(n) = n * log(n)。
//    space: 因为要在map中存n个元素，所以所使用的额外空间就是O(n) = n

//https://leetcode-cn.com/problems/sort-characters-by-frequency/solution/java-top-k-5-by-donoghl-2/
}
