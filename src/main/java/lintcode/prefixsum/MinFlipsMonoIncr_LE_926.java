package lintcode.prefixsum;

public class MinFlipsMonoIncr_LE_926 {
    /*
        -
        For each pos, found how many '1's before (including current pos), and how many '0's after, then add them together,
        flip the before '1's to '0's and the after '0's to '1's to make the string monotone increasing. Repeat at each pos,
        and find the minimum.
        -
        Using PrefixSum

        Ref - https://leetcode.com/problems/flip-string-to-monotone-increasing/solution/
    */
    public int minFlipsMonoIncr(String s) {
        int size = s.length();
        int[] prefix = new int[size+1];
        for (int i = 1; i <= size; i++) {
            prefix[i] = prefix[i-1] + (s.charAt(i-1) == '1' ? 1 : 0);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= size; i++) {
            int after_zero = (size - i) - (prefix[size] - prefix[i]);
            ans = Math.min(ans, prefix[i] + after_zero);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinFlipsMonoIncr_LE_926 solution = new MinFlipsMonoIncr_LE_926();
//        String s = "010110"; //2
        String s = "11011"; //1
        System.out.println(solution.minFlipsMonoIncr(s));
    }
}
