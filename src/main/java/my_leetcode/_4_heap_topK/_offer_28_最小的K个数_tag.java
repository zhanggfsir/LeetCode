package my_leetcode._4_heap_topK;

/*
输入n个整数，找出其中最小的K个数。
例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

 */

import java.util.*;


/*
 * *基于堆排序算法，构建最大堆。时间复杂度为O(nlogk)
 * *如果用快速排序，时间复杂度为O(nlogn)
 * *如果用冒泡排序，时间复杂度为O(n*k)
 */
public class _offer_28_最小的K个数_tag {
    public static void main(String[] args) {

        //todo 比较笨的方法 Arrays.sort(input); 之后取最后几位
    int arr[]={4,5,1,6,2,7,3,8};
        System.out.println(arr[6]);
        System.out.println( GetLeastNumbers_Solution_11(arr,4));
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution_11(int [] input, int k) {
        // 由于本题需要返回ArrayList<Integer>，所以新建之
        ArrayList<Integer> res = new ArrayList<>();
        // 几种特殊情况
        if (k > input.length|| k == 0) {
            return res;
        }
        // 构造优先队列，排序方法是自然数顺序的逆序，所以是个最大堆，这样这个堆的堆顶就是所有数中的最大数
        Queue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < input.length; i++) {
            queue.add(input[i]);
            // 最大堆内数字个数少于k，一直添加到k个
            if (queue.size() > k) {
                queue.poll();
            }

        }
        // 结束上面循环后，堆内就是最小的k个数
        while (!queue.isEmpty()) {
            res.add(queue.remove());
        }
        return res;
    }




    // -----------------看来 博客的记载-----------------



    /*
    找最大的k的元素--建小顶堆；最小的k个元素--建大顶堆 ！！！

    适合海量数据的最大堆 O（nlogk）
    书中提到，第二种堆的方法适合海量数据求k个最小。因为k个数的堆，空间是固定的，当数组超级大，
    那么全存入内存都变得不可行的时候，就需要从外存中慢慢读取数字，然后和这个堆进行比较。

    而方法一[基于快排]就必须把整个数组放入内存中，才能运行，所以不适合海量数据。

    思路
    该方法不改变原数组

    构造一个最大堆，最大堆的性质就是堆顶是所有堆中数字的最大值，那么放入k个数字，
    随后将数字中k个数字之后的数字依次和堆中的最大数字比较（也就是和堆顶数字比较），
    如果小于他，就把堆顶数字弹出，放入小的数字，这样遍历一边数组后，得到一个k个数字的最大堆，
    这个最大堆里存的是最小的k个数!!!

    最大堆的性质由Java中的优先队列，通过自然数的逆序顺序进行维护，也就是下面这句构造：

    Queue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
    */
    public class Solution2 {

        public ArrayList<Integer> GetLeastNumbers_Solution(int [] arr, int k) {

            ArrayList<Integer> res = new ArrayList<>();
            if (k > arr.length|| k == 0) {
                return res;
            }
            Queue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
            for (int i = 0; i < arr.length; i++) {
                queue.add(arr[i]);

                if (queue.size() > k) {
                    queue.poll();
                }
            }
            while (!queue.isEmpty()){
                res.add(queue.poll());
            }
            return res;
        }



        public ArrayList<Integer> GetLeastNumbers_Solution_2(int [] input, int k) {
            // 由于本题需要返回ArrayList<Integer>，所以新建之
            ArrayList<Integer> res = new ArrayList<>();
            // 几种特殊情况
            if (k > input.length|| k == 0) {
                return res;
            }
            // 构造优先队列，排序方法是自然数顺序的逆序，所以是个最大堆，这样这个堆的堆顶就是所有数中的最大数
            Queue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
            for (int i = 0; i < input.length; i++) {
                // 最大堆内数字个数少于k，一直添加到k个
                if (queue.size() < k) {
                    queue.add(input[i]);
                }
                else {
                    // 若堆内最大的数字大于数组中的数字，则将数字出堆，并放入这个小的数
                    if (queue.peek()>input[i]) {
                        // Integer temp = queue.poll(); temp = null; FOR GC
                        queue.remove();
                        queue.offer(input[i]);  // queue 有add 方法 queue.add(input[i]);
                    }
                }
            }
            // 结束上面循环后，堆内就是最小的k个数
            while (!queue.isEmpty()) {
                res.add(queue.remove());
            }
            return res;
        }


//        public static void main(String[] args) {
//            int[] a = {4,5,1,6,2,7,3,8};
////            Solution_40 solution_40 = new Solution_40();
////            System.out.println(solution_40.GetLeastNumbers_Solution(a,4));
//        }
    }




    // 方法1 基于堆排序
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if(k > length || k == 0){
            return result;
        }
        // 用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);  // 如果i1.compareTo(i2)那么就是构建的小顶堆（其实默认也是小顶堆），如果i2.compareTo(i1)就是大顶堆。
            }
        });

        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {  // 比如要4个最小的
                maxHeap.offer(input[i]);
            }
            // 基于堆的优先队列，并没有将元素进行排序，而只是在利用最大堆或最小堆的性质在堆顶保存了最大值或者最小值。
            else if (maxHeap.peek() > input[i]) {
                Integer temp = maxHeap.poll();
                temp = null; // FOR GC
                maxHeap.offer(input[i]);
            }
        }
        // 用迭代器来取优先队列中的数，得到的不一定是有序的。
        // 基于堆的优先队列，并没有将元素进行排序，而只是在利用最大堆或最小堆的性质在堆顶保存了最大值或者最小值。

        //最小堆和最小堆的时间复杂度都是n*logn，但是最小堆在k个数之后添加的话需要调整堆
        //但是最大堆只要每次和顶端的比较就可以啦。另外最小堆不能解决数字动态增加的情况。
        for (Integer integer : maxHeap) {
            System.out.print (integer+ " ");
            result.add(integer);
        }
        return result;
    }


    // 方法2 基于冒泡 由小到大
    //冒泡排序的思想，只不过最外层循环K次就可以了，也就是说不用全部排序，只挑出符合提议的K个就可以。

    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if (k > input.length) {
            return al;
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] < input[j + 1]) { // 位置交换
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
            al.add(input[input.length - i - 1]);// 每次排好一个数 放入一个数
        }

        return al;
    }





    /*
    基于快速排序的变种 O（n） 该方法需要改变原数组
     */
    public class Solution {
        public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
            // 由于本题需要返回ArrayList<Integer>，所以新建之
            ArrayList<Integer> list = new ArrayList<>();
            // 若输入数组长度小于k。直接返回数空的ArrayList
            if(input.length < k){
                return list;
            }

            findKMin(input,0,input.length-1,k);
            for(int i = 0; i < k; i++){
                list.add(input[i]);
            }
            return list;
        }

        private void findKMin(int[] a, int start, int end, int k){
            if(start < end){
                int pos = partition(a, start, end);
                if(pos == k-1){
                    return ;
                }else if(pos < k-1){
                    findKMin(a,pos+1,end,k);
                }else{
                    findKMin(a,start,pos-1,k);
                }
            }
        }

        // 快排中的每次排序实现（挖坑填数法），返回的是交换后start位置
        // （快排一次后的中轴点，中轴点左边全是小于它的，右边都是大于它的）
        public int partition(int[] a, int start, int end){
            int pivot = a[start];
            while(start < end){
                while(start < end && a[end] >= pivot){end--;};
                a[start] = a[end];
                while(start < end && a[start] <= pivot){start++;};
                a[end] = a[start];
            }
            a[start] = pivot;
            return start;
        }
    }
}
