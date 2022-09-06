package lintcode.hashmap.hash_prefix;

public class NumberOfWonderfulSubstrings_LE_1915 {
    /*
        - hashmap + prefix
        - wonderful string looks like is exactly awesome string
        - similar to 1542
    */

    public long wonderfulSubstrings(String word) {
        int[] states = new int[1<<10]; //2^10
        states[0] = 1; //in case the whole prefix is valid
        long ans = 0;

        int key = 0;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            key ^= 1 << (cur-'a');

            //check all even number case
            ans += states[key]; //note should add all previous counts, not just increase by 1

            //check one odd number case
            for (int j = 0; j < 10; j++) {
                int mask = 1<<j;
                int newKey = key ^ mask;
                ans += states[newKey];
            }

            states[key]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfWonderfulSubstrings_LE_1915 solution = new NumberOfWonderfulSubstrings_LE_1915();
//        String s = "aba";//4
        String s = "aabb";//9
//        String s = "he";//2
        System.out.println(solution.wonderfulSubstrings(s));
    }
}
