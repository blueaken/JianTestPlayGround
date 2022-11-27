package lintcode.hashmap.hash_prefix;

import java.util.HashMap;
import java.util.Map;

public class FindLongestAwesomeSubstring_LE_1542_P1 {
    /*
        - hashmap + prefix + state compression
        - similar to 1371
        - ref https://www.youtube.com/watch?v=VRIuNWjJWSU
        =================================
        P1 11.27.2022
        - good problem to solve, similar to prefix sum, but not exactly for sure, the idea of state compression is brilliant
        =================================
    */
    public int longestAwesome(String s) {
        Map<Integer, Integer> state = new HashMap<>(); //state, idx
        state.put(0, -1); //in case the whole prefix is valid

        int key = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - '0';
            key ^= 1 << cur;

            if (state.containsKey(key)) {
                //[state.get(key) + 1 .. i] is an awesome substring
                ans = Math.max(ans, i - state.get(key));
            }
            //continue search other 10 one bit diff patterns, in case there is 1 odd bit
            for (int j = 0; j < 10; j++) {
                int mask = 1 << j;
                int newKey = key ^ mask;
                if (state.containsKey(newKey)) {
                    ans = Math.max(ans, i - state.get(newKey));
                }
            }

            // only record the idx for new key since we are looking for the longest answer
            state.putIfAbsent(key, i);
        }
        return ans;
    }
}
