package ninechapter_algorithm.chapter8_data_structure.longestconsecutivesequence.second;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Author: blueaken
 * Date: 6/3/16 11:57
 */
public class Solution {
    /**
     * @param num: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        if (num == null || num.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int i : num) {
            set.add(i);
        }

        int global = 0;
        while (set.size() > 0) {
            Iterator<Integer> iterator = set.iterator();
            int cur = iterator.next();
            set.remove(cur);
            //search upwards
            int nextInc = cur + 1;
            while (set.contains(nextInc)){
                set.remove(nextInc++);
            }
            //search downwards
            int nextDec = cur - 1;
            while (set.contains(nextDec)){
                set.remove(nextDec--);
            }
            global = Math.max(nextInc - nextDec - 1, global);
        }
        return global;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {0,0,-1};
        System.out.println(solution.longestConsecutive(test));
    }
}
