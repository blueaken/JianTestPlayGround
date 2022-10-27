package lintcode.greedy;

public class GasStation_LE_134 {
    /*
        10.27.2022
        ref labaladong post, 图像法看懂了: O(N)
    */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0, minSum = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if (sum < minSum) {
                start = i + 1;
                minSum = sum;
            }
        }

        //if total cost bigger than total gas then return -1;
        if (sum < 0) {
            return -1;
        }

        return start == n ? 0 : start;
    }
}
