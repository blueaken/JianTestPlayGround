package lintcode.hashmap.hash_prefix;

import java.util.HashMap;
import java.util.Map;

public class FindTheLongestSubstringContainingVowelsInEvenCounts_LE_1371 {
    /*
        - hashmap + prefix + state compress
        - similar to 1542, 1915

    */
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>(); //state, idx
        map.put(0, -1); // in case the whole prefix is valid

        int ans = 0;
        int state = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            //set 5 bit state, 0 - a, 1 - e, 2 - i, 3 - o, 4 -u
            switch (cur) {
                case 'a':
                    state ^= 1 << 0;
                    break;
                case 'e':
                    state ^= 1 << 1;
                    break;
                case 'i':
                    state ^= 1 << 2;
                    break;
                case 'o':
                    state ^= 1 << 3;
                    break;
                case 'u':
                    state ^= 1 << 4;
                    break;
            }

            //find even number of occurrence
            if (map.containsKey(state)) {
                ans = Math.max(ans, i - map.get(state));
            }

            map.putIfAbsent(state, i);
        }

        return ans;
    }
}
