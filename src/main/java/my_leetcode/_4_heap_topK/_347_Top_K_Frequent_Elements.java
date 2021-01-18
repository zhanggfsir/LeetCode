package my_leetcode._4_heap_topK;

import java.util.*;

/*

给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]

提示：
你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
你可以按任意顺序返回答案。
 */
//https://leetcode-cn.com/problems/top-k-frequent-elements/solution/

//前 K 个高频元素
public class _347_Top_K_Frequent_Elements {

    public static void main(String[] args) {
//        int []arr = {1,1,1,2,2,2,2,3};
        int []arr = {1,1,1,1,1,2,2,2,2,3};
        System.out.println(topKFrequent(arr,3));
    }
/*
时间复杂度：O(nlogk)O(nlogk)，nn 表示数组的长度。首先，遍历一遍数组统计元素的频率，这一系列操作的时间复杂度是 O(n)O(n)；接着，遍历用于存储元素频率的 map，如果元素的频率大于最小堆中顶部的元素，则将顶部的元素删除并将该元素加入堆中，这里维护堆的数目是 kk，所以这一系列操作的时间复杂度是 O(nlogk)O(nlogk) 的；因此，总的时间复杂度是 O(nlog⁡k)O(nlog⁡k)。
空间复杂度：O(n)O(n)，最坏情况下（每个元素都不同），map 需要存储 nn 个键值对，优先队列需要存储 kk 个元素，因此，空间复杂度是 O(n)O(n)。

 */
    // 347. 前 K 个高频元素  O(nlogk)
    public static List<Integer> topKFrequent(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> map = new HashMap();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // init q 'the less frequent element first'          // todo map中做了wc 去重
        PriorityQueue<Integer> q =
                new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));

        // keep k top frequent elements in the q
        for (int key: map.keySet()) {
            q.add(key);
            if (q.size() > k)  //  多放一个
                q.poll();
        }

        // build output list
        List<Integer> top_k = new LinkedList();
        while (!q.isEmpty())
            top_k.add(q.poll());
        Collections.reverse(top_k); // 逆序
        return top_k;
    }

    // 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
    // nums = [1,1,1,2,2,3], k = 2  -->  [1,2]
    // 347. 前 K 个高频元素  O(nlogk)
    public static List<Integer> topKFrequent_(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> map = new HashMap();
        for (int n: nums) { //map中做了wc 去重
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));

        // keep k top frequent elements in the heap
        for (int key: map.keySet()) {
            heap.add(key);
            if (heap.size() > k)  //  多放一个
                heap.poll();
        }

        // build output list
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k); // 逆序
        return top_k;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                ((o1, o2) -> map.get(o1) - map.get(o2))
        );
        for(int num : map.keySet()){
            heap.add(num);
            if(heap.size() > k)
                heap.poll();
        }
        int [] result = new int[heap.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = heap.poll();
        }
        return result;
    }

    public List<Integer> topKFrequent3(int[] nums, int k) {

    // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
    HashMap<Integer,Integer> map = new HashMap();
    for(int num : nums){
        if (map.containsKey(num)) {
            map.put(num, map.get(num) + 1);
        } else {
            map.put(num, 1);
        }
    }
    // 遍历map，用最小堆保存频率最大的k个元素
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return map.get(a) - map.get(b);
        }
    });
    for (Integer key : map.keySet()) {
        if (pq.size() < k) {
            pq.add(key);
        } else if (map.get(key) > map.get(pq.peek())) {
            pq.remove();
            pq.add(key);
        }
    }
    // 取出最小堆中的元素
    List<Integer> res = new ArrayList<>();
    while (!pq.isEmpty()) {
        res.add(pq.remove());
    }
    return res;
}



}
