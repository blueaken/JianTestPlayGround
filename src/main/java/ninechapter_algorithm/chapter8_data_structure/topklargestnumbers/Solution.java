package ninechapter_algorithm.chapter8_data_structure.topklargestnumbers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author: blueaken
 * Date: 6/5/16 14:24
 */
public class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // Write your code here
        if (k < 1) {
            return null;
        }
        int[] res = new int[k];
        if (nums == null || nums.length < k) {
            return res;
        }

        Comparator<Integer> maxComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        };
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.length, maxComparator);
        for (int i : nums) {
            maxHeap.add(i);
        }

        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {3,10,1000,-99,4,100};
        int k = 3;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.topk(test, k)));
    }
}
