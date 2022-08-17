package lintcode.sort;

import type.Interval;

import java.util.*;

public class MinMeetingRooms_919 {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    //Idea: 每次发现一个时间冲突，记录下上次会议结束的最小值（使用minHeap），最后minHeap的size就是最小会议室数
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++) {
            if (minHeap.peek() <= intervals.get(i).start)
                minHeap.poll();
            minHeap.offer(intervals.get(i).end);
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
//        List<Interval> input = new ArrayList<Interval>(Arrays.asList(
//                new Interval(900, 910),
//                new Interval(940, 1200),
//                new Interval(950, 1120),
//                new Interval(1100, 1130),
//                new Interval(1500, 1900),
//                new Interval(1800, 2000))
//        );
//        //3

        List<Interval> input = new ArrayList<Interval>(Arrays.asList(
                new Interval(1, 2),
                new Interval(2, 3),
                new Interval(3, 4),
                new Interval(4, 5))
        );
        //1

        MinMeetingRooms_919 solution = new MinMeetingRooms_919();
        System.out.println(solution.minMeetingRooms(input));
    }
}
