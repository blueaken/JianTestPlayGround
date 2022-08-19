package lintcode.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDifferentIntegers_LE_992 {
    /*
        - ref https://www.youtube.com/watch?v=5Ec68Qr2GTM
        - similar to 340, at most K version, the exact K is: AtMostK(K) - AtMostK(K-1)
    */
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtMostKDistinct(nums, k) - subarraysWithAtMostKDistinct(nums, k-1);
    }

    private int subarraysWithAtMostKDistinct(int[] nums, int k) {
        if (k==0) {
            return 0;
        }

        Map<Integer, Integer> count = new HashMap<>(); //Integer, Frequency
        int slow = 0;
        int ret = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            int end = nums[fast];
            count.put(end, count.getOrDefault(end, 0) + 1);
            while (count.size() > k) {
                //while more than k integers, keep moving slow pointer forward
                int start = nums[slow];
                count.put(start, count.get(start) -1);
                if (count.get(start) == 0) {
                    count.remove(start);
                }
                slow++;
            }
            // note: fast是当前固定的右端点。slow是根据fast所能找到的最左边的一个idx使得[slow,fast]之间有at most k distinct character。由此可知，以fast为右端点，以slow,slow+1 ... fast为左端点的区间都满足at most k distinct character，可见这样的区间有fast-slow+1个。
            ret += fast - slow + 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        LongestSubstringWithKDifferentIntegers_LE_992 solution = new LongestSubstringWithKDifferentIntegers_LE_992();
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(solution.subarraysWithKDistinct(nums, k));
    }
}
