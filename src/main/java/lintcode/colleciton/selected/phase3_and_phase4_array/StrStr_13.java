package lintcode.colleciton.selected.phase3_and_phase4_array;

public class StrStr_13 {
    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    public static int strStr(String source, String target) {
        // Write your code here
        //empty string is always a sub string
        if (target.equals("")) return 0;

        int pos = -1;
        for (int i = 0; i < source.length(); i++) {
            pos = i;
            int comparedNum = 0;
            int sourcePos = i;
            boolean matchedChar = false;
            for (int j = 0; j < target.length(); j++) {
                comparedNum++;
                if (source.charAt(sourcePos) == target.charAt(j)) {
                    sourcePos++;
                    matchedChar = true;
                    if (sourcePos == source.length()) {
                        break;
                    }
                    continue;
                } else {
                    matchedChar = false;
                    break;
                }
            }

            if (matchedChar && comparedNum == target.length()) {
                return pos;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        String source = "abcde";
//        String target = "e";
//        String source = "source";
//        String target = "rced";
//        String source = "a";
//        String target = "a";
        String source = "mississippi";
        String target = "issip";
        System.out.println(strStr(source, target));
    }
}
