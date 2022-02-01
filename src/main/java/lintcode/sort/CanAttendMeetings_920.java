package lintcode.sort;

import type.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CanAttendMeetings_920 {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    //Idea: 根据开始时间和结束时间排序，只要前一个会议的结束时间不晚于后一个会议的开始时间就可以参加
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i-1).end) {
                return false;
            }
        }
        return true;
    }
}
