package freq5;

import type.Interval;

import java.util.*;

/**
 * @author jianshen
 */
public class MergeIntervals {
    //level 4
    //use Insert Interval's algorithm
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) return ret;

        //sort intervals per start element
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        Interval merge = intervals.get(0);
        for (int i=1; i< intervals.size(); i++){
            Interval cur = intervals.get(i);
            if (cur.end < merge.start){
                ret.add(cur);
            } else if(cur.start > merge.end){
                ret.add(merge);
                merge = cur;
            } else {
                int min = Math.min(cur.start, merge.start);
                int max = Math.max(cur.end, merge.end);
                merge = new Interval(min, max);
            }
        }

        ret.add(merge);

        return ret;
    }

    public static void main(String[] args){

        Interval s1 = new Interval(1, 3);
        Interval s2 = new Interval(2, 6);
        Interval s3 = new Interval(8, 10);
        Interval s4 = new Interval(15, 18);

        List<Interval> intervals1 = new ArrayList<Interval>();
        intervals1.add(s1);
        intervals1.add(s2);
        intervals1.add(s3);
        intervals1.add(s4);

        List<Interval> ret = merge(intervals1);

        System.out.println(ret);
    }
}
