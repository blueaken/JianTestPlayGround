package ninechapter_algorithm.chapter8_data_structure.longestconsecutivesequence;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Author: blueaken
 * Date: 5/2/16 19:53
 */
public class Solution {
    /**
     * @param num: A list of integers
     * @return an integer
     */
    public static int longestConsecutive(int[] num) {
        // write you code here
        if (num == null || num.length == 0) {
            return -1;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }

        int longest = 1;
        while(!set.isEmpty()) {
            Iterator<Integer> iterator = set.iterator();
            int cur = iterator.next();
            set.remove(cur);
            int down = cur - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }
            int up = cur + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            longest = Math.max(up - down - 1, longest);
        }
        return longest;
    }

    public static void main(String[] args) {
        //expect 9
        //int[] test = {5,4,3,2,1,6,7,8,9,200,1,3,2};

        //expect 7
        int[] test = {-3,2,8,5,1,7,-8,2,-8,-4,-1,6,-6,9,6,0,-7,4,5,-4,8,2,0,-2,-6,9,-4,-1};

        System.out.println(longestConsecutive(test));

    }
}
