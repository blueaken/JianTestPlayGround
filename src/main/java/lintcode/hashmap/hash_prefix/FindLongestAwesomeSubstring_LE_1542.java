package lintcode.hashmap.hash_prefix;

import java.util.HashMap;
import java.util.Map;

public class FindLongestAwesomeSubstring_LE_1542 {

    /*
    - hashmap + prefix + state compression
    - similar to 1371
    - ref https://www.youtube.com/watch?v=VRIuNWjJWSU
*/
    int ans = 0;
    Map<Integer, Integer> state = new HashMap<>(); //key, idx

    public int longestAwesome(String s) {

        state.put(0, -1); //in case the whole prefix is valid
        int[] count = new int[10]; //one for each digit

        int key = 0;
        for (int j = 0; j < s.length(); j++) {
            int cur = s.charAt(j) - '0';
            count[cur]++;
//            int key = count2key(count);
            key ^= 1 << cur;

            findValid(j, key);
        }
        return ans;
    }

    private void findValid(int j, int key) {
        if (state.containsKey(key)) {
            ans = Math.max(ans, j - state.get(key));
        }

        //continue search other 10 one bit diff patterns, in case there is longer length
        for (int k = 0; k < 10; k++) {
            int mask = 1 << k;
            int newKey = key ^ mask;
            if (state.containsKey(newKey)) {
                ans = Math.max(ans, j - state.get(newKey));
            }
        }
        //at last add new key with value of j for future use
        state.putIfAbsent(key, j);
        return;
    }

    //can be optimized with , here is for easier to understand
    private int count2key(int[] count) {
        int key = 0;
        for (int i = 0; i < count.length; i++) {
            key ^= (count[i] % 2) << i;
        }
        return key;
    }

//     the char with odd count cannot be more than 1
//     [i:j]
//     X X X [i X X X j] X X

//     usually fix right index and find one/all valid right index i

//     for a given character
//     freq[j] = count[j] - count[i-1]

//     valid awesome substring if
//     1. all character count are even
//     2. only one character count is odd

//     for any valid awesome substring we'd like to find the smallest i
//        hash map - key: odd or even of prefix, value: idx

//        if key at j is 1000000001, key at i -1 is also 1000000001, same odd/even (case 1)
//        if key at j is 1000000001, key at i -1 is one bit diff from 1000000001 (case 2)

    public static void main(String[] args) {
        FindLongestAwesomeSubstring_LE_1542 solution = new FindLongestAwesomeSubstring_LE_1542();
        String s = "0844"; //3
        System.out.println(solution.longestAwesome(s));


//        int number = 9;
//        int result = 1 << number;
//        System.out.println(result);
    }
}
