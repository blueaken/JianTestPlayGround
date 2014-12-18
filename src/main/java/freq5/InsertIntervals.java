package freq5;

import type.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 7/26/14 5:17 下午
 */
public class InsertIntervals {
    //level 4
    //动态合并的问题：
    //通过遍历intervals，和newInterval对比：
    //  1 如果比newInterval小：直接加入新集合
    //  2 如果有overlap，动态改变newInterval为新的区间，继续合并
    //  3 如果比newInterval大：加入newInterval到新集合，然后把newInterval更新为当前对象
    //  读flight for your dreams 解法，确实巧妙，我一开始的merge sort的递归法不能解决最后一步的合并。
    //  http://blog.csdn.net/fightforyourdream/article/details/16876485
    //  可以再看看red black tree解法，学习下RBT这种数据结构

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            ret.add(newInterval);
            return ret;
        }

        Interval merge = newInterval;
        for (int i=0; i< intervals.size(); i++){
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
        Interval t1 = new Interval(1, 3);
        Interval t2 = new Interval(6, 9);

        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(t1);
        intervals.add(t2);

        Interval new1 = new Interval(2, 5);

        List<Interval> ret = insert(intervals, new1);

        System.out.println(ret);

        Interval s1 = new Interval(1, 2);
        Interval s2 = new Interval(3, 5);
        Interval s3 = new Interval(6, 7);
        Interval s4 = new Interval(8, 10);
        Interval s5 = new Interval(12, 16);

        List<Interval> intervals1 = new ArrayList<Interval>();
        intervals1.add(s1);
        intervals1.add(s2);
        intervals1.add(s3);
        intervals1.add(s4);
        intervals1.add(s5);

        Interval new2 = new Interval(4, 9);

        ret = insert(intervals1, new2);

        System.out.println(ret);
    }
}
