package lintcode.stack.monotonic;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement_LE_496 {
    /*
        Ref - https://www.bilibili.com/video/BV17z4y1y7tS?spm_id_from=333.999.0.0, but not ACed, need refactor(fixed).
        Time is O(n) - actually n + n + m, since nums1 is subset of nums2, can be simplified to O(n)
    */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            //maintain monotonic stack from the end of input array (fix a bug from original video)
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            //put result into target
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            //push current element
            stack.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
