package lintcode.greedy;

import java.util.*;

public class LeastNumberOfUniqueIntegersAfterKRemovals_LE_1481 {
    /*
      - idea is to sort the HashMap by value, read some post and decide to use List of Map.Entry with customer Comparator
      - but it is not easy to write an elegant code
      - ref 花花's post and finish the final version: https://zxi.mytechroad.com/blog/hashtable/leetcode-1481-least-number-of-unique-integers-after-k-removals/
      - Time is O(NLogN)
    * */
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        //build freq count map
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : arr) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        //retrieve freq into array and sort
        int[] freq = new int[count.size()];
        int pos = 0;
        for (Integer key : count.keySet()) {
            freq[pos++] = count.get(key);
        }
        Arrays.sort(freq);

        //removal from the lowest freq first by greedy
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

    public static void main(String[] args) {
        LeastNumberOfUniqueIntegersAfterKRemovals_LE_1481 solution = new LeastNumberOfUniqueIntegersAfterKRemovals_LE_1481();
//        int[] arr = {5,5,4};
//        int k = 1;
//        //1

        int[] arr = {4,3,1,1,3,3,2};
        int k = 3;
        //2

//        int[] arr = {2,1,1,3,3,3};
//        int k = 3;
//        //1

        System.out.println(solution.findLeastNumOfUniqueInts(arr, k));
    }
}
