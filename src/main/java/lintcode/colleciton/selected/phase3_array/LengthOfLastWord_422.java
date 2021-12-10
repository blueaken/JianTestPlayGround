package lintcode.colleciton.selected.phase3_array;

public class LengthOfLastWord_422 {
    /**
     * @param s: A string
     * @return: the length of last word
     */
    //Key Idea: 从最后一个单词处理
    public int lengthOfLastWord(String s) {
        // write your code here
        if (s.isEmpty()) return 0;
        int len = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) == ' ') continue;
            if (s.charAt(i-1) != ' ') {
                len++;
                continue;
            } else {
                break;
            }
        }

        // compense for the first position before ' '
        return len + 1;
    }
}
