package lintcode.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2_LE_219 {
    /**
     12.05.2022
     try solve with 东哥 sliding window template
     - note this solution is not same with 东哥's
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); //val, index

        int left = 0, right = 0;
        while (right < nums.length) {
            int r = nums[right];
            if (map.containsKey(r)) {
                if (right - map.get(r) <= k) {
                    return true;
                }
            }
            map.put(r, right); //always update the index of current val, since we want to check if the gap is within k
            right++;

            //no left point need move in this case;
        }
        return false;
    }
}
