package freq5;

import type.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianshen
 */
public class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) return null;

        List<Interval> result = new ArrayList<Interval>();
        result = rec(intervals);

        return result;
    }

    private static List<Interval> rec(List<Interval> in){

    }
}
