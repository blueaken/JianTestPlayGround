package ninechapter_system_design.chapter2_database_design.consistenthashing;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 3/20/16 3:51 PM
 */
public class Solution {
    /**
     * @param n a positive integer
     * @return n x 3 matrix
     */
    public static List<List<Integer>> consistentHashing(int n) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();

        //init
        List<Integer> init = new ArrayList<>();
        init.add(0);
        init.add(359);
        init.add(1);
        result.add(init);
        if (n == 1) {
            return result;
        }

        for (int i = 2; i <= n; i++) {
            //find the max interval
            int max = 0;
            int maxPos = 0;
            for (int j = 0; j < result.size(); j++) {
                List<Integer> current = result.get(j);
                int temp = current.get(1) - current.get(0);
                if (temp > max) {
                    max = temp;
                    maxPos = j;
                }
            }

            //split the max interval
            List<Integer> maxInterval = result.get(maxPos);
            int maxEnd = maxInterval.get(1);
            int midVal = (maxInterval.get(0) + maxEnd)/2;
            maxInterval.set(1, midVal);

            List<Integer> newItem = new ArrayList<>();
            newItem.add(midVal+1);
            newItem.add(maxEnd);
            newItem.add(i);
            result.add(newItem);
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(consistentHashing(n));
    }
}
