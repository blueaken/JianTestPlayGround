package lintcode.others.count_subarray_by_element;

import java.util.Stack;

public class TotalStrengthOfWizards_LE_2281 {
    /*
        - take some time to understand the request, it is similar to 907, the diff is one product is "The total of all the individual strengths of the wizards in the group", instead of only the min value itself; this part uses a Presum variant solution, leave it for now, practice 907 first
        - since the strength.length is of 10^5 level, not good to use travese all subarray combination, will TLE for sure
        - use Monotonic Stack solution, similar to 907.
        - ref https://www.youtube.com/watch?v=HGCm9PkFd58
    */
    public int totalStrength(int[] strength) {
        int size = strength.length;
        long MOD = (long)1e9 + 7;

        //make the array 1 based to match the video, refactor later
        long[] nums = new long[size + 1];
        for (int i = 1; i <= size; i++) {
            nums[i] = strength[i - 1];
        }

        long[] preSum = new long[size + 2];
        for (int i = 1; i <= size; i++) {
            preSum[i] = (preSum[i - 1] + nums[i]) % MOD;
        }

        long[] preSum2 = new long[size + 2];
        for (int i = 1; i <= size; i++) {
            preSum2[i] = (preSum2[i - 1] + nums[i] * i) % MOD;
        }

        Stack<Integer> stack = new Stack<>();
        //PLE, 单调递增栈
        int[] ple = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            //note ">=" here, while NLE, "=" case will not be calculated again
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            ple[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(i);
        }
        stack.clear();

        //NLE, 单调递增栈
        int[] nle = new int[size + 1];
        for (int i = size; i >= 1; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            nle[i] = stack.isEmpty() ? size + 1 : stack.peek();
            stack.push(i);
        }

        long ans = 0l;
        for (int i = 1; i <= size; i++) {
            int a = ple[i], b = nle[i];
            int x = i - a, y = b - i;
            //note 减法可能出现负数，需要加上MOD并取余数
            long left = ((preSum2[i - 1] - preSum2[a]) - (preSum[i - 1] - preSum[a]) * a % MOD + MOD) % MOD;
            long right = ((preSum[b - 1] - preSum[i]) * b % MOD - (preSum2[b - 1] - preSum2[i]) + MOD) % MOD;
            long mid = nums[i] * x * y % MOD;
            ans = (ans + (left * y % MOD + mid + right * x % MOD) * nums[i] % MOD) % MOD;
        }

        return (int) ans;

        /*
            nums[a]: prev smaller of nums[i]
            nums[b]: next smaller of nums[i]

            x = i - a;
            y = b - i;

            a x x x x i x x x b
              1 2 3 4   3 2 1

            ret[i] = nums[*] * {
               (nums[a+1] * 1 + nums[a+2] * 2 + nums[a+3] * 3 + nums[a+4] * 4) * y
             + (nums[i+1] * 3 + nums[i+2] * 2 + nums[i+1] * 1) * x
             + nums[i] * x * y
            }

            Let preSum2[i] = nums[1] * 1 + nums[2] * 2 + nums[3] * 3 + ... + nums[i] * i,
            then preSum2[i-1] - preSum2[a]
            = nums[a+1] * (a+1) + nums[a+2] * (a+2) + nums[a+3] * (a+3) + ... + nums[i-1] * (i-1)
            = "what we want 1" + nums[a+1] * a + nums[a+2] * a + ... + nums[i - 1] * a
            = "what we want 1" + (sum[a+1 : i-1]) * a
            = "what we want 1" + (preSum[i-1] - preSum[a]) * a
            (
                Note: nums[a+4] = nums[i - 1],
                "what we want 1" = nums[a+1] * 1 + nums[a+2] * 2 + nums[a+3] * 3 + nums[a+4] * 4
            )

            and preSum2[b-1] - preSum2[i]
            = nums[i+1] * (i+1) + nums[i+2] * (i+2) + ... + nums[b-1] * (b-1)
            = sum[i+1 : b-1] * b - "what we want 2"
            = (preSum[b-1] - preSum[i]) * b - "what we want 2"
            (
                Note:
                i + 1 = b - i - 1;
                "what we want 2" = nums[b-i-1] * (b-i-1) + nums[i+2] * 2 + ... + nums[b-2] * 2 + nums[b-1] * 1
            )
         */
    }

    public static void main(String[] args) {
        TotalStrengthOfWizards_LE_2281 solution = new TotalStrengthOfWizards_LE_2281();
        int[] strength = {1,3,1,2};//44

        System.out.println(solution.totalStrength(strength));
    }
}
