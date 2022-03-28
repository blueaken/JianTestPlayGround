package lintcode.interval;

import type.Interval;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoInterval_839 {
    /**
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    //Idea: to Interval, if an element is within overlapped aread, can be overlapped
    //      ref - https://www.lintcode.com/problem/839/solution/17298
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        // write your code here
        if (list1 == null || list1.size() == 0) {
            return list2;
        }
        if (list2 == null || list2.size() == 0) {
            return list1;
        }

        List<Interval> res = new ArrayList<>();
        int i = 0, j = 0;
        Interval last = null, merge = null;
        while (i < list1.size() && j < list2.size()) {
            //select Interval to merge
            Interval l1 = list1.get(i);
            Interval l2 = list2.get(j);
            if (l1.start < l2.start) {
                merge = l1;
                i++;
            } else {
                merge = l2;
                j++;
            }

            last = mergeInterval(res, last, merge);

        }

        while (i < list1.size()) {
            merge = list1.get(i++);
            last = mergeInterval(res, last, merge);
        }
        while (j < list2.size()) {
            merge = list2.get(j++);
            last = mergeInterval(res, last, merge);
        }
        if (last != null) {
            res.add(last);
        }

        return res;
    }

    private Interval mergeInterval (List<Interval> res, Interval last, Interval merge) {
        if (last == null) {
            return merge;
        }

        if (last.end < merge.start) {
            res.add(last);
            return merge;
        }

        // merge.start overlapped, need to decide the new end element
        last.end = Math.max(last.end, merge.end);
        return last;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(1,2);
        Interval i2 = new Interval(3,4);
        List<Interval> l1 = new ArrayList<>();
        l1.add(i1);
        l1.add(i2);

        Interval j1 = new Interval(2,3);
        Interval j2 = new Interval(5,6);
        List<Interval> l2 = new ArrayList<>();
        l2.add(j1);
        l2.add(j2);

        MergeTwoInterval_839 solution = new MergeTwoInterval_839();
        solution.mergeTwoInterval(l1, l2);
    }
}
