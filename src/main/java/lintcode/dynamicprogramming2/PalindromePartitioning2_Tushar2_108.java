package lintcode.dynamicprogramming2;

public class PalindromePartitioning2_Tushar2_108 {
    /**
     * @param str a string
     * @return an integer
     */
    //Ref - Tushar code - https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/PalindromePartition.java
    // Time Complexity - O(N^2) better than the video, which is O(N^3)
    /*
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * Return the minimum cuts needed for a palindrome partitioning of s.
     * https://leetcode.com/problems/palindrome-partitioning-ii/
     */
    public int minCut(String str){
        if (str.length() == 0) {
            return 0;
        }

        int[] cut = new int[str.length()];
        boolean isPal[][] = new boolean[str.length()][str.length()];
        for (int i = 1; i < str.length(); i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == str.charAt(j) && (i <= j + 1 || isPal[j + 1][i - 1])) { //skip getDict calculatioin cost
                    isPal[j][i] = true;
                    min = Math.min(min, j == 0 ? 0 : 1 + cut[j - 1]);
                }
            }
            cut[i] = min;
        }
        return cut[str.length() - 1];
    }

    public static void main(String[] args) {
//        String input = "aab"; //1
        String input = "leet"; //2

        PalindromePartitioning2_Tushar2_108 solution = new PalindromePartitioning2_Tushar2_108();
        System.out.println(solution.minCut(input));
    }
}
