package lintcode.twopointers;

public class GetLength_1474 {
    /**
     * @param k: The number of words in the article
     * @param lim: TThe minimum number of words a phrase should contain
     * @param str: The article
     * @return: Return the length of shortest phrase
     */
    //Idea: ref - https://www.lintcode.com/problem/1474/solution/26919
    public int getLength(int k, int lim, String[] str) {
        // Write your code here
        if (str.length == 0 || k > str.length) {
            return 0;
        }

        int left = 0, right = 0, sum = 0, minSum = Integer.MAX_VALUE;
        while (left < str.length - k) {
            while (right < str.length && (right - left < k || sum < lim)) {
                sum += str[right].length();
                right++;
            }
            if (right - left >= k && sum >= lim ) {
                minSum = Math.min(sum, minSum);
            }
            sum -= str[left].length();
            left++;
        }

        return minSum;
    }
}
