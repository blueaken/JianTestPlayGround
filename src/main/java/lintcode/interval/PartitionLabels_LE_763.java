package lintcode.interval;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class PartitionLabels_LE_763 {
    /*
        Idea is to put each char's start and end position into interval, then merge overlap intervals, and get the answer. More intuitive than the greedy solution.
        - Time is O(N)
    */
    public List<Integer> partitionLabels(String s) {
        //build intervals array, note with linkedhashmap the result is in the order of insert order, which is the start position
        LinkedHashMap<Character, int[]> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            int[] interval = new int[2];
            if (!map.containsKey(cur)) {
                interval[0] = i;
                interval[1] = i;
            } else {
                interval = map.get(cur);
                interval[1] = i;
            }
            map.put(cur, interval);
        }

        //merge intervals if there is overlap
        LinkedList<int[]> list = new LinkedList<>();
        int count = 0;
        for (Character c : map.keySet()) {
            count++;
            int[] curInterval = map.get(c);
            //put the 1st interval into list
            if (count == 1) {
                list.add(curInterval);
                continue;
            }
            if (curInterval[0] <= list.getLast()[1]) {
                list.getLast()[1] = Math.max(curInterval[1], list.getLast()[1]);
            } else {
                list.add(curInterval);
            }
        }

        //generate the result
        List<Integer> res = new ArrayList<>();
        for (int[] interval : list) {
            res.add(interval[1] - interval[0] + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        PartitionLabels_LE_763 solution = new PartitionLabels_LE_763();
        String s = "ababcbacadefegdehijhklij";

        System.out.println(solution.partitionLabels(s));
    }
}
