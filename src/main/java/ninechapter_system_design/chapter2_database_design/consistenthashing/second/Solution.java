package ninechapter_system_design.chapter2_database_design.consistenthashing.second;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 6/1/16 13:07
 */
public class Solution {
    /**
     * @param n a positive integer
     * @return n x 3 matrix
     */
    public List<List<Integer>> consistentHashing(int n) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

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
            //find max interval
            int maxInterval = 0;
            int maxPos = 0;
            for (int j = 0; j < result.size(); j++) {
                List<Integer> current = result.get(j);
                int temp = current.get(1) - current.get(0);
                if (temp > maxInterval) {
                    maxInterval = temp;
                    maxPos = j;
                }
            }

            //split
            List<Integer> maxSlot = result.get(maxPos);
            int splitPoint = (maxSlot.get(0) + maxSlot.get(1)) / 2;
            List<Integer> newSlot = new ArrayList<>();
            newSlot.add(splitPoint + 1);
            newSlot.add(maxSlot.get(1));
            newSlot.add(i);
            result.add(newSlot);

            maxSlot.set(1, splitPoint);
        }
        return result;
    }
}
