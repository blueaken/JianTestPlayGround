package lintcode.dynamicprogramming2;

public class PalindromePartitioning2_Tushar_108 {
    /**
     * @param s a string
     * @return an integer
     */
    //Ref - https://www.youtube.com/watch?v=lDYIvtBVmgo, wordbreak/palindrome dp
    public int minCut(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        //init
        int size = s.length();
        int[][] res = new int[size][size];
        for (int i = 0; i < size; i++) {
            res[i][i] = 0; // len = 1 cases
        }

        //dp
        for (int len = 2; len <= size; len++) {
            for (int i = 0; i <= size - len; i++) {
                int j = i + len - 1;
                if (len == 2) {
                    res[i][j] = s.charAt(i) == s.charAt(j) ? 0 : 1;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j) && isPalindrome(s.substring(i, j+1))) {
                    res[i][j] = 0;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i + 1; k <= j; k++) {
                        int cur = 1 + res[i][k-1] + res[k][j];
                        min = Math.min(min, cur);
                    }
                    res[i][j] = min;
                }
            }
        }
        return res[0][size-1];
    }

    private boolean isPalindrome(String s) {
        int len = s.length();
        int start = 0, end = len - 1;
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return start >= end;
    }

    public static void main(String[] args) {
//        String input = "aab"; //1
        String input = "leet"; //2

        PalindromePartitioning2_Tushar_108 solution = new PalindromePartitioning2_Tushar_108();
        System.out.println(solution.minCut(input));
    }
}
