package _08_highFrequency;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/meeting-rooms-ii/
 */
/*
给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，
为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。

示例 1:

输入: [[0, 30],[5, 10],[15, 20]]
输出: 2
示例 2:

输入: [[7,10],[2,4]]
输出: 1

 */

//   2种解法都是 Ologn
public class _253_会议室_II {

    //  最小堆 删除 增减 O(n)  查看O(1)  // TODO 需要再看一眼
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        // 存放所有会议的开始时间
        int[] begins = new int[intervals.length];
        // 存放所有会议的结束时间
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            begins[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        // 排序
        Arrays.sort(begins);            // nlogn
        Arrays.sort(ends);

        // 如果begin数组中有一个值大于end数据，endIdx++,否则新开一个会议室
        int room = 0, endIdx = 0;
        for (int begin : begins) {
            if (begin >= ends[endIdx]) { // 能重复利用会议室 开始时间 > 占用会议室里面最快结束时间
                endIdx++;
            } else { // 需要新开一个会议室
                room++;
            }
        }

        return room;
    }

    /*
        1.开始时间排序
        2.声明堆，用于存放结束时间。并将第一个会议室的结束时间放入堆
        3.loop
            3.1 i号会议室可用--i会议室的开始时间 > 堆顶结束时间
                删堆顶 将i会议室结束时间放入堆
            3.2 i号会议室不可用
                将i号会议室的结束时间放入堆中
     */
    //  [开始时间，结束时间]  _253_会议室_II  此方法为准
    public int minMeetingRooms1(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        // 按照会议的开始时间，从小到大排序  nlogn
        Arrays.sort(intervals, (m1, m2) -> m1[0] - m2[0]);

        // 创建一个最小堆（存放每一个"在开"会议的结束时间）。最小堆顶值
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // 堆中放会议结束时间
        // 添加0号会议的结束时间
        heap.add(intervals[0][1]);

        // 堆顶的含义：目前占用的会议室中最早结束的时间
        for (int i = 1; i < intervals.length; i++) { // nlogn
            // 会议室能用 删除堆顶[ 堆的最小值]，{此会议室要给i号会议室用}；放入i号会议的结束时间
            // i号会议的开始时间 >= 堆顶 结束时间     [5, 10],[15, 20]  开始时间15 堆顶10 表示有一个会议[5,10]已经开完
            if (intervals[i][0] >= heap.peek()) {   // 此时移除栈顶    O(1)  //tmp TODO 解题关键 开始时间 > 结束时间 当前会议室，会议已经开完，即会议室可用，移除旧的" 堆顶结束时间"
                heap.remove();                                     // logn
                heap.add(intervals[i][1]);
            }else {
                // 将i号会议的结束时间加入堆中
                heap.add(intervals[i][1]); // logn
            }
        }
        return heap.size();
    }



    //  [开始时间，结束时间]
    public int minMeetingRooms1_1(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        // 按照会议的开始时间，从小到大排序  nlogn
        Arrays.sort(intervals, (m1, m2) -> m1[0] - m2[0]);

        // 创建一个最小堆（存放每一个会议的结束时间）。最小堆顶值
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // 添加0号会议的结束时间
        heap.add(intervals[0][1]);

        // 堆顶的含义：目前占用的会议室中最早结束的时间 !! 重要
        for (int i = 1; i < intervals.length; i++) { // nlogn
            // i号会议的开始时间 >= 堆顶 结束时间 [不用新开辟会议室]     [5, 10],[15, 20]  开始时间15 堆顶10 表示有一个会议[5,10]已经开完
            if (intervals[i][0] >= heap.peek()) {   // 此时移除栈顶
                heap.remove();
                heap.add(intervals[i][1]);
            }
            // 将i号会议的结束时间加入堆中
            else {
                heap.add(intervals[i][1]);
            }
        }

        return heap.size();
    }


}
