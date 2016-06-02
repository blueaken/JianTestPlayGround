package ninechapter_algorithm.chapter7_array_and_number.intersectionoftwoarrays;

import java.util.*;

/**
 * Author: blueaken
 * Date: 6/2/16 08:42
 */
public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        int[] empty = new int[0];
        if (nums1 == null || nums1.length == 0
                || nums2 == null || nums2.length == 0) {
            return empty;
        }

        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                list.add(i);
                set.remove(i);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a1 = {1,2,2,1};
        int[] a2 = {2,2};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.intersection(a1, a2)));
    }
}
