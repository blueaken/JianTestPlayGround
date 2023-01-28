package lintcode.binarysearch.labuladong;

import java.util.ArrayList;

public class NumberOfMatchingSubsequences_LE_792 {
    /**
     1.28.2023
     - almost same as LE 392's 2 solution O(MN) and binary search O(MLogN)
     - let's try both, O(MN) TLE as expected, O(MLogN) ACed
     */
    public int numMatchingSubseq(String s, String[] words) {
        // O(MLogN Binary Search)
        // int m = words.length;
        int n = s.length();

        // pre handling String s
        ArrayList<Integer>[] index = new ArrayList[256];
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if (index[cur] == null) {
                index[cur] = new ArrayList<>();
            }
            index[cur].add(i);
        }

        int res = 0;
        for (String word : words) {
            int i = 0; // String word index
            int j = 0; // String s index
            for (; i < word.length(); i++) {
                char cur = word.charAt(i);
                ArrayList<Integer> arr = index[cur];
                if (arr == null) {
                    break;
                }
                int pos = left_bound(arr, j);
                if (pos == -1) {
                    break;
                }
                j = arr.get(pos) + 1;
            }
            if (i == word.length()) {
                res++;
            }
        }
        return res;
    }

    private int left_bound(ArrayList<Integer> arr, int target) {
        int left = 0, right = arr.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left == arr.size()) {
            return -1;
        }
        return left;
    }
}
