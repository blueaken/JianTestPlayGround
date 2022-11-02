package lintcode.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeastNumberOfUniqueIntegersAfterKRemovals_LE_1481_P1 {
    /*
      - idea is to sort the HashMap by value, read some post and decide to use List of Map.Entry with customer Comparator
      - but it is not easy to write an elegant code
      - ref 花花's post and finish the final version: https://zxi.mytechroad.com/blog/hashtable/leetcode-1481-least-number-of-unique-integers-after-k-removals/
      - Time is O(NLogN)
      =====================
      P1 11.02.2022
      =====================
    */
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        //build freq map
        Map<Integer, Integer> map = new HashMap<>(); //val, freq
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        //build freq arr from map and sort
        int n = map.keySet().size();
        int[] freq = new int[n];
        int pos = 0;
        for (Integer key : map.keySet()) {
            freq[pos++] = map.get(key);
        }
        Arrays.sort(freq);

        //remove k times from smallest freq
        int ans = freq.length;
        pos = 0;
        for (int i = 0; i < k; i++) {
            if (--freq[pos] == 0) {
                pos++;
                ans--;
            }
        }
        return ans;
    }
}
