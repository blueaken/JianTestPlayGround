package lintcode.math.prime;

import java.util.*;

public class Test {

    String ans;
    boolean[] used;
    Map<Character, Integer> orderMap;
    public String customSortString(String order, String s) {
        orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        int n = s.length();
        StringBuilder sb = new StringBuilder();
        used = new boolean[n];

        backtrack(s, sb);
        return ans;
    }

    void backtrack(String s, StringBuilder sb) {
        if (sb.length() == s.length()) {
            ans = sb.toString();
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            sb.append(s.charAt(i));
            if (check(sb.toString())) {
                backtrack(s, sb);
            }
            used[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }

    boolean check(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!orderMap.keySet().contains(s.charAt(i))) {
                continue;
            }
            int cur = orderMap.get(s.charAt(i));
            for (int j = i+1; j < s.length(); j++) {
                if (!orderMap.keySet().contains(s.charAt(j))) {
                    continue;
                }
                int nxt = orderMap.get(s.charAt(j));
                if (cur > nxt) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Test test = new Test();

        String order = "hucw";
        String s = "utzoampdgkalexslxoqfkdjoczajxtuhqyxvlfatmptqdsochtdzgypsfkgqwbgqbcamdqnqztaqhqanirikahtmalzqjjxtqfnh";

        System.out.println(test.customSortString(order, s));
    }
}


