package lintcode.stack.monotonic.labuladong;

import java.util.Stack;

public class FinalPricesWithSpecialDiscountInShop_LE_1475 {
    /**
     12.28.2022
     - next less or equal element probelm
     */
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] nle = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while(stack.size() > 0 && stack.peek() > prices[i]) {
                stack.pop();
            }
            nle[i] = stack.size() == 0 ? 0 : stack.peek();
            stack.push(prices[i]);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prices[i] - nle[i];
        }
        return res;
    }
}
