package lintcode.stack.monotonic;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement_LE_496_P1 {
    /*
        P1 10.10.2022
    */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Map<Integer, Integer> nge = new HashMap<>(); //val, nge val

        //build nge map
        Stack<Integer> stack = new Stack<>();//index
        for (int i = n -1 ; i >= 0; i--) {
            //nge - mono increasing stack
            while (stack.size() > 0 && nums2[i] > nums2[stack.peek()]) {
                stack.pop();
            }
            int ngeVal = stack.size() == 0 ? -1 : nums2[stack.peek()];
            nge.put(nums2[i], ngeVal);
            stack.push(i);
        }

        int m = nums1.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = nge.get(nums1[i]);
        }
        return res;
    }
}
