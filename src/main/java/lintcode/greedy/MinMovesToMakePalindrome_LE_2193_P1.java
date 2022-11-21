package lintcode.greedy;

public class MinMovesToMakePalindrome_LE_2193_P1 {
    /*
        ref discussion - https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/discuss/2466919/Clean-Java-Code-With-Explanation
        - it is obviously a solution to make palindrome, but how to prove the result is the min?
        - ref the 1st half part of Huifeng Guan video for the prove
        - Time is O(N^2)
        ===============================
        P1 11.21.2022
        - ref prev notes
        ===============================
    */
    public int minMovesToMakePalindrome(String s) {
        int start = 0, end = s.length() - 1;
        int ans = 0;
        char[] arr = s.toCharArray();

        while (start < end) {
            if (arr[start] == arr[end]) {
                start++; end--;
                continue;
            }

            int r = end;
            while (arr[r] != arr[start]) {
                r--;
            }

            if (r == start) {
                //the unique char is in the start pos
                swap(arr, r, r+1);
                ans++;
            } else {
                while (r < end) {
                    swap(arr, r, r+1);
                    ans++;
                    r++;
                }
            }
        }
        return ans;
    }

    private void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }
}
