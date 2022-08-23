package lintcode.unionfind;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence_LE_128 {
    /*
        - note the diff with 1143. Longest Common SubSequence
        - ref 花花 https://www.youtube.com/watch?v=rc2QdQ7U78I，if O(n) not required, then just sort then sort the
          longest consecutive sequence; there are 2 solutions
        - 1. HashMap
    */
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); //node, len(bountry as current node)
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            //skip duplicate num
            if (map.containsKey(nums[i])) {
                continue;
            }

            //find consecutive neighbor from map
            int l = 0, r = 0, len = 0;
            if (map.containsKey(nums[i]-1)) {
                l = map.get(nums[i]-1);
            }
            if (map.containsKey(nums[i]+1)) {
                r = map.get(nums[i]+1);
            }
            // in case 2 neighbors
            if (l > 0 && r > 0) {
                len = l + r + 1;
                map.put(nums[i], len);
                map.put(nums[i] - l, len);
                map.put(nums[i] + r, len);
            } else if (l > 0) { // 1 neighbor case
                len = l + 1;
                map.put(nums[i], len);
                map.put(nums[i] - l, len);
            } else if (r > 0) { // 1 neighbor case
                len = r + 1;
                map.put(nums[i], r + 1);
                map.put(nums[i] + r, len);
            } else { // new node init len to 1
                map.put(nums[i], 1);
            }
            ans = Math.max(ans, map.get(nums[i]));
        }
        return ans;
    }
}
