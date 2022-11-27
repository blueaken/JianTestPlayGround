package lintcode.hashmap.hash_prefix;

import java.util.HashMap;
import java.util.Map;

public class NumberOfWonderfulSubstrings_LE_1915_P1 {
    /*
        - hashmap + prefix
        - wonderful string looks like is exactly awesome string
        - similar to 1542
        =========================
        P1 11.27.2022
        =========================
    */
    public long wonderfulSubstrings(String word) {
        Map<Integer, Integer> state = new HashMap<>(); //state, count
        state.put(0, 1); //in case the whole prefix is valid

        int key = 0;
        long ans = 0;
        for (int i = 0; i < word.length(); i++) {
            int cur = word.charAt(i) - 'a';
            key ^= 1 << cur;
            if (state.containsKey(key)) {
                //note should add all previous counts, not just increase by 1
                ans += state.get(key);
            }
            //check odd case
            for (int j = 0; j < 10; j++) {
                int mask = 1 << j;
                int newKey = key ^ mask;
                if (state.containsKey(newKey)) {
                    ans += state.get(newKey);
                }
            }
            state.put(key, state.getOrDefault(key, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        NumberOfWonderfulSubstrings_LE_1915_P1 solution = new NumberOfWonderfulSubstrings_LE_1915_P1();
//        String s = "aba";//4
        String s = "aabb";//9
//        String s = "he";//2
        System.out.println(solution.wonderfulSubstrings(s));
    }
}
