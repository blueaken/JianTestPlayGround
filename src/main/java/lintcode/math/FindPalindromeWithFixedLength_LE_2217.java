package lintcode.math;

public class FindPalindromeWithFixedLength_LE_2217 {
    public long[] kthPalindrome(int[] queries, int n) {
        int half = (n+1) / 2;
        int start = (int)Math.pow(10, half-1);
        int end = (int)Math.pow(10, half) - 1;
        int total = (end-start)+1;

        long[] answer = new long[n];
        for (int i = 0; i < queries.length; i++) {
            int cur = queries[i];
            if (cur <= total) {
                String leftHalf = String.valueOf(start+cur-1);

                StringBuilder temp = new StringBuilder(leftHalf);
                String rightHalf = temp.reverse().toString();

                answer[i] = Long.valueOf(leftHalf + rightHalf.substring(n%2));
            } else {
                answer[i] = -1;
            }
        }
        return answer;
    }

}
