package lintcode.colleciton.selected.phase3_and_phase4_array;

public class StrStr_Better_Way_13 {
    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    // first check the requirement is not to implement KMP, just an algorithm to find substring
    // ref: https://zh.wikipedia.org/wiki/KMP%E7%AE%97%E6%B3%95
    public static int strStr(String source, String target) {
        // Write your code here
        //empty string is always a sub string
        int lenSource = source.length();
        int lenTarget = target.length();

        // if target is empty then always return 0, no matter what the source is
        if (lenTarget == 0) return 0;

        if (lenTarget > lenSource) return -1;

        for (int i = 0; i < lenSource - lenTarget + 1; i++) {
            int pos = i;
            int comparedN = 0;
            for (int j = 0; j < lenTarget; j++) {
                if (source.charAt(pos) == target.charAt(j)) {
                    pos++;
                    comparedN++;
                    if (comparedN == lenTarget) {
                        return i;
                    }
                } else {
                    break;
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        String source = "abcde";
        String target = "e";

//        String source = "source";
//        String target = "rced";

//        String source = "a";
//        String target = "a";

//        String source = "mississippi";
//        String target = "issip";
        System.out.println(strStr(source, target));
    }
}
