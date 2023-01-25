package lintcode.stack.labuladong;

public class MinimumInsertionsToBalanceParenthesesString_LE_1541 {
    /**
     1.25.2023
     ref 东哥 括号 post
     greedy type
     */
    public int minInsertions(String s) {
        int insert = 0; // 插入左括号或者右括号次数
        int need = 0; // 需要右括号的次数
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if ('(' == cur) {
                need += 2;
                if (need % 2 == 1) {
                    // 如果右括号需要数量为奇数，则至少需要插入一个右括号，保持右括号数量为偶数
                    insert++;
                    need--;
                }
            }
            if (')' == cur) {
                need--;
                if (need == -1) {
                    // 需要在左边插入一个左括号
                    insert++;
                    // 更新右括号需要数
                    need = 1;
                }
            }
        }
        return insert + need;
    }
}
