package lintcode.stack.labuladong;

public class MinimumAddToMakeParenthesesValid_LE_921 {
    /**
     1.25.2023
     ref 东哥 括号 post
     */
    public int minAddToMakeValid(String s) {
        int insert = 0; // 左括号插入次数
        int need = 0; // 右括号需要次数
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                need++;
            }
            if (cur == ')') {
                need--;
            }
            // if need is -1 then insert one left parenthsis to validate current substring
            if (need == -1) {
                insert++;
                need = 0;
            }
        }
        return insert + need;
    }
}
