package lintcode.math.bitmanipulation;

public class FindTheDifference_LE_389 {
    /**
     1.16.2023
     利用异或性质
     */
    public char findTheDifference(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i) ^ t.charAt(i);
        }

        res ^= t.charAt(t.length()-1);
        return (char)res;
    }
}
