package lintcode.others.count_subarray_by_element;

import java.util.Stack;

public class TotalStrengthOfWizards_LE_2281_P2 {
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
        ===================================
        P2 10.10.2022
        example - to a random subarray below, i is the weakest element
        a - ple, b - nle
        a [X X X X X X X X X i X X X X X] b
              x: i - a       |  y: b - i

        then ans = nums[i] * total of all strength when nums[i] is the weakest
                 = nums[i] * {
                   (nums[a+1] * 1 + nums[a+2] * 2 + ... nums[i-1] * 9) * y +
                   nums[i] * x * y +
                   (nums[i+1] * 5 + nums[i+2] * 4 + nums[b-1] * 1) * x
                 }

        Let PreSum2[i] = nums[i] * i, then PreSum2[i-1] - PreSum2[a]
        = nums[a+1]*(a+1) + nums[a+2]*(a+2) + ... + nums[i-1]*(i-1)
        = "what we want 1" + Sum[a+1 : i-1] * a

        then  PreSum2[b-1] - Presum2[i]
            = nums[i+1] * (i+1) + nums[i+2] * (i+2) + .. + nums[b-1]*(b-1)
            = Sum[i+1 : b-1] * b - "what we want 2"
        -------------------------------------
        note: need to conver the array to 1-index based for ease of coding
    */
    public int totalStrength(int[] strength) {
        long mod = (long)1e9 + 7;

        int n = strength.length;
        //conver to 1 index based
        long[] nums = new long[n+1];
        for (int i = 0; i < n; i++) {
            nums[i+1] = strength[i];
        }

        long[] ps1 = new long[n+1];
        long[] ps2 = new long[n+1];
        for (int i = 1; i <= n; i++) {
            ps1[i] = (ps1[i-1] + nums[i]) % mod ;
            ps2[i] = (ps2[i-1] + nums[i] * i % mod) % mod;
        }

        int[] ple = new int[n+1];
        int[] nle = new int[n+1];
        Stack<Integer> stack = new Stack<>();//index
        for (int i = 1; i <= n; i++) {
            //ple - monotonic increasing stack
            while (stack.size() > 0 && nums[i] < nums[stack.peek()]) {
                stack.pop();
            }
            ple[i] = stack.size() == 0 ? 0 : stack.peek();
            stack.push(i);
        }
        stack.clear();

        for (int i = n; i >= 1; i--) {
            //nle - monotonic decreasing stack
            while (stack.size() > 0 && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }
            nle[i] = stack.size() == 0 ? n+1 : stack.peek();
            stack.push(i);
        }

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int a = ple[i], b = nle[i];
            int x = i - a, y = b - i;

            long left = ((ps2[i-1] - ps2[a]) - (ps1[i-1] - ps1[a]) * a % mod + mod) * y % mod;
            long right = ((ps1[b-1] - ps1[i]) * b % mod - (ps2[b-1] - ps2[i]) + mod) * x % mod;
            long mid = nums[i] * x * y % mod;

            ans = (ans + nums[i] * (left + mid + right) % mod) % mod;
        }


        return (int)ans;

    }
}
