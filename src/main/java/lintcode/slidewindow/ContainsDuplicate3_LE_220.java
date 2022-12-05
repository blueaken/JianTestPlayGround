package lintcode.slidewindow;

import java.util.TreeSet;

public class ContainsDuplicate3_LE_220 {
    /**
     12.05.2022
     similar to 219
     solve by 东哥 sliding window template
     - 利用TreeSet的ceiling和floor方法
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> window = new TreeSet<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            //check the element strictly bigger than current
            Integer ceiling = window.ceiling(nums[right]);
            if (ceiling != null && ceiling - nums[right] <= valueDiff) {
                return true;
            }

            //check the element strictly smaller than current
            Integer floor = window.floor(nums[right]);
            if (floor != null && nums[right] - floor <= valueDiff) {
                return true;
            }

            window.add(nums[right]);
            right++;

            while (right - left > indexDiff) {
                window.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}
