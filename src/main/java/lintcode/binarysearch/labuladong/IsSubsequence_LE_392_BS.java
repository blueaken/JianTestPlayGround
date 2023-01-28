package lintcode.binarysearch.labuladong;

import java.util.ArrayList;

public class IsSubsequence_LE_392_BS {
    /**
     1.28.2023
     ref 东哥 post, there is a straightward O(N) solution
     =======================
     - ref 东哥 post
     - for the follow up question, when N is very big, to use the previous O(N) solution, need add a for loop for each input string s, which is O(MN).
     - we can use binary search to optimize here, make the soltion O(MLogN) in the follow up case
     - 利用left bound BS 如果找不到会返回比target大1位的index
     */
    public boolean isSubsequence(String s, String t) {
        // pre handling of String t
        ArrayList<Integer>[] index = new ArrayList[256];
        for (int i = 0; i < t.length(); i++) {
            char cur = t.charAt(i);
            if (index[cur] == null) {
                index[cur] = new ArrayList<>();
            }
            index[cur].add(i);
        }

        // index on String t
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            ArrayList<Integer> arr = index[s.charAt(i)];
            // if current char of s not exist in String t
            if (arr == null) {
                return false;
            }
            int pos = left_bound(arr, j);
            if (pos == -1) {
                return false;
            }
            j = arr.get(pos) + 1;
        }
        return true;
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
