package lintcode.monotonicqueue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SlidingWindowMaximum_LE_239 {
    /*
        - Brute Force is obvious, Time is O(n - k + 1) * k, Space is O(1)
        - The trick is how to reach O(n), yes, with Monotonic Queue, here we need access the front element, so pass Monotonic Stack
        - ref 花花 https://www.youtube.com/watch?v=2SXqBsTR6a8&t=6s
        - Time is O(N), Space is O(N)
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int size = nums.length;
        int[] ans = new int[size - k + 1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            while (dq.size() > 0 && nums[i] > dq.getLast()) {
                dq.removeLast();
            }
            dq.addLast(nums[i]);
            if (i - k + 1 >= 0) {
                ans[i - k + 1] = dq.getFirst();
                //note if the window's first element is the current max, pop it to avoid effect next calc
                if (nums[i - k + 1] == dq.getFirst()) {
                    dq.removeFirst();
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum_LE_239 solution = new SlidingWindowMaximum_LE_239();
        int nums[] = {-7,-8,7,5,7,1,6,0};
        int k = 4;
        //[7,7,7,7,7]
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, k)));
    }
}
