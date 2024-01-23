package lintcode.backtrack;

import java.util.HashMap;
import java.util.Map;

public class OptimalAccountBalancing_LE_465 {
    /**
     1.23.24
     - solve by backttrack
     - ref: https://leetcode.com/problems/optimal-account-balancing/solutions/1157154/java-clean-backtracking-solution-with-comments/
     */
    public int minTransfers(int[][] transactions) {
        // id, amount after transactions complete
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] tran : transactions) {
            int fromId = tran[0], toId = tran[1], amount = tran[2];
            map.put(fromId, map.getOrDefault(fromId, 0) - amount);
            map.put(toId, map.getOrDefault(toId, 0) + amount);
        }

        // id does not affect the result after this step
        int n = map.keySet().size();
        int[] balance = new int[n];
        int i = 0;
        for (Integer key : map.keySet()) {
            balance[i++] = map.get(key);
        }

        return backtrack(0, balance);
    }

    int backtrack(int pos, int[] balance) {
        // base case 1 - reach the end of array, all balance cleared
        if (pos == balance.length) {
            return 0;
        }

        // base case 2 - if current balance is 0, then we can skip it
        if (balance[pos] == 0) {
            return backtrack(pos+1, balance);
        }

        int curBalance = balance[pos];
        int res = Integer.MAX_VALUE;
        for (int i = pos+1; i < balance.length; i++) {
            /** note
             - if curBalance and balance[i] are both positive/negative, then meaningless to operate on them
             - if curBalance or balance[i] is 0, then also meaningless to operate on them
             */
            if (curBalance * balance[i] >= 0) {
                continue;
            }

            balance[i] += curBalance; // add current balance to balance[i], current balance is cleared at this time
            res = Math.min(res, 1 + backtrack(pos+1, balance));
            balance[i] -= curBalance;
        }
        return res;
    }

    public static void main(String[] args) {
        OptimalAccountBalancing_LE_465 solution = new OptimalAccountBalancing_LE_465();
        int[][] transactions = {{0,1,10},{2,0,5}}; // 2
        System.out.println(solution.minTransfers(transactions));
    }
}
