package lintcode.others.count_subarray_by_element;

import java.util.ArrayDeque;
import java.util.Deque;

public class TotalStrengthOfWizards_LE_2281_P1 {

    /*
        P1
        - one of the most hardest
        - check the video and previous notes again

        - take some time to understand the request, it is similar to 907, the diff is one product is "The total of all the individual strengths of the wizards in the group", instead of only the min value itself; this part uses a Presum variant solution, leave it for now, practice 907 first
        - since the strength.length is of 10^5 level, not good to use travese all subarray combination, will TLE for sure
        - use Monotonic Stack solution, similar to 907.
        - ref https://www.youtube.com/watch?v=HGCm9PkFd58
        ===================================
        use an example -
        let a - ple, b - nle;

        a [X X X X X X X X i X X X X X X] b
            x: i - a       | y: b - i

        ans = nums[i] * {
             (nums[a+1] * 1 + nums[a+2] * 2 + nums[a+3] * 3 + ... + nums[i-1] * 8) * y
           + (nums[i+1] * 6 + nums[i+2] * 5 + ... nums[b-1] * 1) * x
           + nums[i] * x * y
        }

        Let PreSum2[i] = nums[i] * i,
        Then PreSum2[i-1] - PreSum2[a]
        = nums[a+1] * (a+1) + nums[a+2]*(a+2) + ... + nums[i-1] * (i-1)
        = "What we want 1" + Sum[a+1 : i-1] * a

        Presum2[b-1] - Presum2[i]
        = nums[i+1] * (i+1) + nums[i+2] * (i+2) + ... + nums[b-1] * (b-1)
        = Sum[i+1 : b-1] * b - "What we want 2"

    */
    public int totalStrength(int[] strength) {
        long mod = (long)1e9 + 7;

        //conver to 1 based for the ease of formula code
        int n = strength.length;
        long[] nums = new long[n+1];

        for (int i = 1; i <= n; i++) {
            nums[i] = strength[i-1];
        }

        //preSum1 & preSum2
        long[] ps1 = new long[n+1];
        long[] ps2 = new long[n+1];
        for (int i = 1; i <= n; i++) {
            ps1[i] = (ps1[i-1] + nums[i]) % mod;
            ps2[i] = (ps2[i-1] + nums[i] * i % mod) % mod;
        }

        //ple & nle
        int[] ple = new int[n+1];
        int[] nle = new int[n+1];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] >= nums[i]) {
                stack.removeLast();
            }
            ple[i] = stack.isEmpty() ? 0 : stack.peekLast();
            stack.addLast(i);
        }
        stack.clear();

        for (int i = n; i >= 1; i--) {
            while (!stack.isEmpty() && nums[stack.peekLast()] > nums[i]) {
                stack.removeLast();
            }
            nle[i] = stack.isEmpty() ? n+1 : stack.peekLast();
            stack.addLast(i);
        }

        //put it together
        long sum = 0l;
        for (int i = 1; i <= n; i++) {
            int a = ple[i], b = nle[i];
            int x = i - a, y = b - i;

            long left = ((ps2[i-1] - ps2[a]) - (ps1[i-1] - ps1[a]) * a % mod + mod) % mod;
            long mid = nums[i] * x * y % mod;
            long right = ((ps1[b-1] - ps1[i]) * b % mod - (ps2[b-1] - ps2[i]) + mod) % mod;

            sum = (sum + (left * y % mod + mid + right * x % mod) * nums[i] % mod) % mod;
        }

        return (int)(sum);
    }

}
