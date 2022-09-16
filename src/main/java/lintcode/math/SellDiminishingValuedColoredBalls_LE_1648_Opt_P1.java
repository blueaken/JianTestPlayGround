package lintcode.math;

import java.util.Arrays;

public class SellDiminishingValuedColoredBalls_LE_1648_Opt_P1 {
    /*
    P1
    - read prev notes and HuaHua video again and redo
    - 等差数列求和公式: (首项 + 末项) * 项数 / 2
    - many corner case to consider
    =================
     gut feeling - greedy with the help of max heap, Time - O(NlogM), N - order number, M - color kinds
        - get TLE, since color kinds is of 10^9, so the solution should optimize on this
        - Ref 花花酱讲解 https://www.youtube.com/watch?v=kBxqAnWo9Wo，使用等差数列公式辅助提高性能, Time - O(M)
        - It is tricky, all test cases passed but still got TLE, try use array instead of Heap to improve performance
        - Java cannot sort reverse order on primitive type array, like int[], need to access the max element from the end
    =================
    */
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);

        int mod = (int)1e9 + 7;
        int n = inventory.length;

        long cur = inventory[n-1];
        int idx = n-1;
        int color = 0;

        long ans = 0, sum = 0;
        while (orders > 0) {
            while (idx >= 0 && inventory[idx] == cur) {
                color++;
                idx--;
            }

            long nxt = idx < 0 ? 0 : inventory[idx];
            long tran_n = cur - nxt;
            long count = Math.min(orders, color * tran_n);

            if (color * tran_n <= orders) {
                sum = (cur + nxt + 1) * tran_n / 2 * color % mod;
            } else {
                tran_n = orders / color;
                int r = orders % color;
                long nxt_p = cur - tran_n;
                sum = ((cur + nxt_p + 1) * tran_n / 2 * color + nxt_p * r) % mod;
            }
            ans = (ans + sum) % mod;

            orders -= count;
            cur = nxt;
        }
        return (int)ans;
    }
}
