package lintcode.twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumLenSubarrayPositiveProduct_LE_1567 {
    /*
        Ref Description Hints - Time O(N^2)
    */
    public int getMaxLen(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //split the array into subarrays by zeros, and record the neg num counts
        List<List<Integer>> whole = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int neg_count = 0;
        int list_id = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(nums[i]);
                if (nums[i] < 0) {
                    neg_count++;
                }
                continue;
            }
            if (list.size() > 0) {
                whole.add(list);
                map.put(list_id++, neg_count);
                neg_count = 0;
                list = new ArrayList<>();
            }
        }
        //add the last sublist
        whole.add(list);
        map.put(list_id++, neg_count);

        int ans = 0;
        for (int i = 0; i < whole.size(); i++) {
            List<Integer> l = whole.get(i);
            //if neg count is even, the whole subarray counts
            if (map.get(i) % 2 == 0) {
                ans = Math.max(ans, l.size());
                continue;
            }
            //else compare the first neg num position from head and tail, pick the longer size subarray
            int l_pos = 0;
            while (l_pos < l.size() && l.get(l_pos) > 0) {
                l_pos++;
            }
            int size1 = l.size() - l_pos - 1;

            int r_pos = l.size() - 1;
            while (r_pos >= 0 && l.get(r_pos) > 0) {
                r_pos--;
            }
            int size2 = r_pos;
            ans = Math.max(ans, Math.max(size1, size2));
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumLenSubarrayPositiveProduct_LE_1567 solution = new MaximumLenSubarrayPositiveProduct_LE_1567();
//        int[] nums = {1,-2,-3,4};//4
        int[] nums = {0,1,-2,-3,-4};//3
        System.out.println(solution.getMaxLen(nums));
    }
}
