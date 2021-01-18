package my_leetcode._4_heap_topK;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
215. 数组中的第K个最大元素 todo  在一个整数序列中 寻找第k大的元素

在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，
而不是第 k 个不同的元素。

示例 1:
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5

示例 2:
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4


 */
public class _215_KthLargestElementinanArray {

    // 方法1 使用快排 O(n(logn))
    public static void main(String[] args) {
        int arr[]={3,2,1,5,6,4,6};
        findKthLargest(arr,3);
//        System.out.println(findKthLargest(arr,2));;
    }
//int
    /*
    最小堆，得到是最大的K个值，位于根节点的就是堆的最小值。
// todo PriorityQueue 默认就是最小堆，存储最大的K个值。 默认是小弟弟--最小堆
// todo 这句话要记死  求最大的K个数，用最小堆，PriorityQueue默认是最小堆，最小堆存储K个最大值，且位于根节点的就是这个堆的最小值
PriorityQueue默认就是最小堆，依次加入元素到堆中，多于k个就删除根节点，
最后得到的就是最大的k个值，位于根节点的就是这个堆的最小值，也就是整个数组第k大的值


复杂度分析

时间复杂度 : O(Nlogk)。
空间复杂度 : O(k)，用于存储堆元素。 K个最大元素

思路是创建一个大顶堆，将所有数组中的元素加入堆中，并保持堆的大小小于等于 k。这样，堆中就保留了前 k 个最大的元素。这样，堆顶的元素就是正确答案。

像大小为 k 的堆中添加元素的时间复杂度为 {O}(\log k)O(logk)，我们将重复该操作 N 次，故总时间复杂度为 {O}(N \log k)O(Nlogk)。

在 Python 的 heapq 库中有一个 nlargest 方法，具有同样的时间复杂度，能将代码简化到只有一行。

本方法优化了时间复杂度，但需要 {O}(k)O(k) 的空间复杂度。


     */
        public static  void findKthLargest(int[] nums, int k) {
            // init heap 'the smallest element first'
            //  最小堆，这样这个堆的堆顶就是所有数中的最小数
            PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
            // todo 记住这是 最小堆的初始化方式
//            PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

            // keep k largest elements in the heap
            for (int n: nums) {
                heap.add(n);
                if (heap.size() > k)
                    heap.poll();
            }
            for(int i:heap){
                System.out.println(i);
            }
//                if(!heap.isEmpty()){
//                    System.out.println(heap.poll());
//                }
            // output
//            return heap.poll();
        }


    /*
     PriorityQueue 默认就是最小堆，存储最大的K个值。 默认是小弟弟--最小堆
    求最大的K个数，用最小堆，PriorityQueue默认是最小堆，最小堆存储K个最大值，且位于根节点的就是这个堆的最小值
    时间复杂度 : O(Nlogk)。   空间复杂度 : O(k)，用于存储堆元素。
    215 数组中的第K个最大元素 -- TOP-K
     */
    public static  void findKthLargest_(int[] nums, int k) {
        //  最小堆，这样这个堆的堆顶就是所有数中的最小数
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        // todo 记住这是 最小堆的初始化方式
        //PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        for (int n: nums) { // keep k largest elements in the heap
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }
        for(int i:heap){
            System.out.println(i);
        }
        //while(!heap.isEmpty()){
        //    System.out.println(heap.poll());
        //}
        //return heap.poll();
    }


//一种不能再暴力的解法
public int findKthLargest5(int[] nums, int k) {
    int len = nums.length;
    Arrays.sort(nums);
    return nums[len - k];
}

}

