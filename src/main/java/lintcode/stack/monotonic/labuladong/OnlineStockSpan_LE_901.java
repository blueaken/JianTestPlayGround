package lintcode.stack.monotonic.labuladong;

import java.util.Stack;

/**
 12.28.2022
 - pge problem, also ref 东哥 post
 */
public class OnlineStockSpan_LE_901 {
    //记录价格，之前小于等于当前价格的最大连续天数
    Stack<int[]> stack = new Stack<>();

    public OnlineStockSpan_LE_901() {

    }

    public int next(int price) {
        //默认加上当前天数
        int count = 1;
        while (stack.size() > 0 && stack.peek()[0] <= price) {
            int[] cur = stack.pop();
            count += cur[1];
        }
        stack.push(new int[] {price, count});
        return count;
    }
}
