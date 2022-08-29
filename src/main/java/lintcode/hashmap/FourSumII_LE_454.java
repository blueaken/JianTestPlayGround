package lintcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class FourSumII_LE_454 {
    /*
        - ref solution discussion, using HashMap to solve it in O(N^2)
        - for general case KSumII, can divide the input arrays into 2 parts and similarily solve it with HashMap in O(N^(k/2)), which is O(N^2) for 4SumII case.
    */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                int temp = n1 + n2;
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }

        int ans = 0;
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                int temp = n3 + n4;
                ans += map.getOrDefault(-temp, 0);
            }
        }

        return ans;
    }
}
