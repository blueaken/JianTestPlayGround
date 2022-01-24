package lintcode.strings;

import java.util.Arrays;

public class WhetherStringsAreSubstrings_255 {
    /**
     * @param sourceString: a string
     * @param targetStrings: a string array
     * @return: Returns a bool array indicating whether each string in targetStrings is a substring of the sourceString
     */
    //可以直接用String api调用; 但也试了自己写方法判断；
    public boolean[] whetherStringsAreSubstrings(String sourceString, String[] targetStrings) {
        // write your code here
        if (targetStrings.length == 0) {
            return new boolean[0];
        }

        boolean[] res = new boolean[targetStrings.length];
        for (int i = 0; i < targetStrings.length; i++) {
            String cur = targetStrings[i];
            res[i] = sourceString.contains(cur);
        }
        return res;
    }

    // private boolean isSub(String source, String target) {
    //     int sLen = source.length();
    //     int tLen = target.length();
    //     if (tLen > sLen) {
    //         return false;
    //     }
    //     int sPos = 0;
    //     while (sPos < sLen - tLen + 1) {
    //         int tPos = 0;
    //         boolean needBack = false;
    //         while (tPos < tLen && source.charAt(sPos) == target.charAt(tPos)) {
    //             //in case of duplicate chars
    //             if (sPos != sLen - 1 && source.charAt(sPos) == source.charAt(sPos + 1)) {
    //                 needBack = true;
    //             }
    //             sPos++;
    //             tPos++;
    //         }
    //         if (tPos == tLen) {
    //             return true;
    //         }
    //         if (!needBack) {
    //             sPos++;
    //         }
    //     }
    //     return false;
    // }

    public static void main(String[] args) {
        String source = "abbcdefg";
        String[] targets = {"cde"};

        WhetherStringsAreSubstrings_255 solution = new WhetherStringsAreSubstrings_255();
        System.out.println(Arrays.toString(solution.whetherStringsAreSubstrings(source, targets)));
    }
}
