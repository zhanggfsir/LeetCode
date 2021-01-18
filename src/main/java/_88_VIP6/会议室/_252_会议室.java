package _88_VIP6.会议室;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/meeting-rooms/
 */

/*
给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，请你判断一个人是否能够参加这里面的全部会议。

示例 1:

输入: [[0,30],[5,10],[15,20]]
输出: false
1
2
示例 2:

输入: [[7,10],[2,4]]
输出: true

 */
public class _252_会议室 {
    // 判断一个人是否能够参加这里面的全部会议。
    public static boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return true;

//        System.out.println(Arrays.toString(intervals));
        // 按照会议的开始时间，从小到大排序
        Arrays.sort(intervals, (m1, m2) -> m1[0] - m2[0]);
//        System.out.println(Arrays.toString(intervals));

        // 遍历每一个会议
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1])  //  会议不能参加的定义： 如果当前会议的开始时间 < 上一个会议的结束时间
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals={{7,10},{2,4}};       //{[[7,10],[2,4]]};
        System.out.println(canAttendMeetings(intervals));
    }
}




