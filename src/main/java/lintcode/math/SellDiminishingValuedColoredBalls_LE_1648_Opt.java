package lintcode.math;

import java.util.Arrays;

public class SellDiminishingValuedColoredBalls_LE_1648_Opt {
    /*
        gut feeling - greedy with the help of max heap, Time - O(NlogM), N - order number, M - color kinds
        - get TLE, since color kinds is of 10^9, so the solution should optimize on this
        - Ref 花花酱讲解 https://www.youtube.com/watch?v=kBxqAnWo9Wo，使用等差数列公式辅助提高性能, Time - O(M)
        - It is tricky, all test cases passed but still got TLE, try use array instead of Heap to improve performance
        - Java cannot sort reverse order on primitive type array, like int[], need to access the max element from the end
    */
    public int maxProfit(int[] inventory, int orders) {

        Arrays.sort(inventory);
        int numberOfBalls = inventory.length;
        long ans = 0;
        long mod = (long)1e9 + 7;

        long cur = inventory[numberOfBalls-1];
        int idx = numberOfBalls - 1;
        int colorCount = 0;

        while (orders > 0) {

            while (idx >= 0 && inventory[idx] == cur) {
                idx--;
                colorCount++;
            }

            long nxt = idx == -1 ? 0 : inventory[idx];

            //用改进等差数列公式简化计算
            long tranNum = cur - nxt;
            long count = Math.min(orders, colorCount * tranNum);
            int remainder = 0;
            if (orders < colorCount * tranNum) {
                tranNum = orders / colorCount;
                remainder = orders % colorCount;
            }
            long nxt_p = cur - tranNum;
            ans = (ans + ((cur + nxt_p + 1) * tranNum / 2) * colorCount + nxt_p * remainder) % mod;

            orders -= count;
            cur = nxt;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        SellDiminishingValuedColoredBalls_LE_1648_Opt solution = new SellDiminishingValuedColoredBalls_LE_1648_Opt();
//        int[] inventory = {2, 5};
//        int orders = 4;
//        //14

//        int[] inventory = {3, 5};
//        int orders = 6;
//        //19

        int[] inventory = {1000000000};
        int orders = 1000000000;
        //21

        System.out.println(solution.maxProfit(inventory, orders));
    }
}
