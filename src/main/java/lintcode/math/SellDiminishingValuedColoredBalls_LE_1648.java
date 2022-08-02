package lintcode.math;

import java.util.PriorityQueue;

public class SellDiminishingValuedColoredBalls_LE_1648 {
    /*
        gut feeling - greedy with the help of max heap, Time - O(NlogM), N - order number, M - color kinds
        - get TLE, since color kinds is of 10^9, so the solution should optimize on this
    */
    public int maxProfit(int[] inventory, int orders) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i : inventory) {
            maxHeap.add(i);
        }

        long ans = 0;
        long mod = (long)1e9 + 7;
        for (int i = 1; i <= orders; i++) {
            if (maxHeap.size() == 0) {
                break;
            }
            Integer cur = maxHeap.poll();
            ans = (ans + cur) % mod;
            maxHeap.add(cur - 1);
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        SellDiminishingValuedColoredBalls_LE_1648 solution = new SellDiminishingValuedColoredBalls_LE_1648();
//        int[] inventory = {2, 5};
//        int orders = 4;
//        //14

        int[] inventory = {3, 5};
        int orders = 6;
        //19

        System.out.println(solution.maxProfit(inventory, orders));
    }
}
