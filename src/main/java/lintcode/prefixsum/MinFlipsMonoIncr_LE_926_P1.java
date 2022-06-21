package lintcode.prefixsum;

public class MinFlipsMonoIncr_LE_926_P1 {
    /*
        -
        For each pos, found how many '1's before (including current pos), aka the prefix sum, and how many '0's after, then add them together,
        flip the before '1's to '0's and the after '0's to '1's to make the string monotone increasing. Repeat at each pos,
        and find the minimum.

        Ref - https://leetcode.com/problems/flip-string-to-monotone-increasing/solution/
    */
    public int minFlipsMonoIncr(String s) {
        int size = s.length();
        int[] prefixSum = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            prefixSum[i] = prefixSum[i-1] + (s.charAt(i-1) == '1' ? 1 : 0);
        }

        int ans = Integer.MAX_VALUE;
        //i start from 0, to include the min flip position is in the after zeros.
        for (int i = 0; i <= size; i++) {
            int after_position_nums = size - i;
            int after_ones = prefixSum[size] - prefixSum[i];
            int after_zeros = after_position_nums - after_ones;
            //before ones (including current pos),aka prefix sum, and after zeros together is the total flip number for each position
            int total_flip_num = prefixSum[i] + after_zeros;
            ans = Math.min(ans, total_flip_num);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinFlipsMonoIncr_LE_926_P1 solution = new MinFlipsMonoIncr_LE_926_P1();
//        String s = "010110"; //2
        String s = "11011"; //1
        System.out.println(solution.minFlipsMonoIncr(s));
    }
}
