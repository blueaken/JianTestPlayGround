package lintcode.math.prime;

import java.util.*;

public class Tes {

    /**
     10.24.23
     - find a very good video on it, a little wordy but clear logic, however still feels difficult after watching:
     - 1. the idea of semi-palindrome, not appear LC problems before
     - 2. after that use a top down DP to loop the whole string
     - 3. need to optimize the performance by pre calculate the semi-palindrome
     */
    int[][] mem, change;
    String s;
    public int minimumChanges(String s, int k) {
        this.s = s;
        int n = s.length();

        // pre calculate of min changes for substring [i, j], covers all possibile substrings
        change = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String cur = s.substring(i, j+1);
                change[i][j] = minChangesToMakeSemiPalindrome(cur);
            }
        }

        mem = new int[n][k+1];
        for (int[] arr : mem) {
            Arrays.fill(arr, -1);
        }

        dp(0, k);
        return mem[0][k];
    }

    // returns min changes to make sub string [index..] k semi-palindromes
    int dp(int index, int k) {
        int n = s.length();
        if (index == n) {
            // if index == n & k != 0 then there is no solution
            return k == 0 ? 0 : Integer.MAX_VALUE;
        }
        // we should only proceed when index < n & k > 0
        if (k == 0) {
            return Integer.MAX_VALUE;
        }

        if (mem[index][k] != -1) {
            return mem[index][k];
        }

        int res = Integer.MAX_VALUE;
        for (int i = index; i < n; i++) {
            // len == 1 is not a valid semi palindrome
            if (index == i) {
                continue;
            }
            int next = dp(i+1, k-1);
            if (next != Integer.MAX_VALUE) {
                int cur = change[index][i] + next;
                res = Math.min(res, cur);
            }
        }

        mem[index][k] = res;
        return mem[index][k];
    }

    // returns min changes to make s string semi-palindrome, Time is O(N*SQRT(N)/2)
    int minChangesToMakeSemiPalindrome(String str) {
        int n = str.length();
        int ans = Integer.MAX_VALUE;
        for (int factor : getFactors(n)) {
            int len = n / factor;
            int curChange = 0;
            for (int offset = 0; offset < factor; offset++) {
                for (int index = 0; index < len/2; index++) {
                    int left = index * factor + offset;
                    int right = (len - index -1) * factor + offset; // bug
                    if (str.charAt(left) != str.charAt(right)) {
                        curChange++;
                    }
                }
            }

            ans = Math.min(ans, curChange);
        }
        return ans;
    }


    // returns factors for n excludes n itself
    List<Integer> getFactors(int n) {
        List<Integer> res = new LinkedList<>();
        //simply O(N) works, but O(Sqrt(N)) is better
        int sqrtN = (int)Math.sqrt(n);
        for (int i = 1; i <= sqrtN; i++) {
            if (n % i == 0) {
                res.add(i);
            }
        }

        boolean isPerfect = sqrtN * sqrtN == n;
        int end = isPerfect ? res.size() - 2 : res.size() - 1;
        for (int i = end; i > 0; i--) {
            res.add(n / res.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        Tes solution = new Tes();

//        String s = "abcac";
//        int k = 2;
//        // 1

        String s = "abcdef";
        int k = 2;
        // 2

        System.out.println(solution.minimumChanges(s, k));
    }
}
