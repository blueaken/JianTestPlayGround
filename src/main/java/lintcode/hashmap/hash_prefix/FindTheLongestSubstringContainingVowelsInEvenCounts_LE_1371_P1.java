package lintcode.hashmap.hash_prefix;

import java.util.HashMap;
import java.util.Map;

public class FindTheLongestSubstringContainingVowelsInEvenCounts_LE_1371_P1 {
    /*
        - hashmap + prefix + state compress
        - similar to 1542, 1915
        ============================
        P1 11.27.2022
        ============================
    */
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> state = new HashMap<>();//state, idx
        state.put(0, -1);

        int key = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            switch (cur) {
                case 'a':
                    key ^= 1 << 0;
                    break;
                case 'e':
                    key ^= 1 << 1;
                    break;
                case 'i':
                    key ^= 1 << 2;
                    break;
                case 'o':
                    key ^= 1 << 3;
                    break;
                case 'u':
                    key ^= 1 << 4;
                    break;
            }

            if (state.containsKey(key)) {
                ans = Math.max(ans, i - state.get(key));
            }

            //since we are looking for longest only record the idx for the new key
            state.putIfAbsent(key, i);
        }
        return ans;
    }
}
