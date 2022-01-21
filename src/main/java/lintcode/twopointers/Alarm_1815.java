package lintcode.twopointers;

public class Alarm_1815 {
    /**
     * @param n:
     * @param k:
     * @param len:
     * @param num: //same as problem
     * @return: //return long
     */
    //Idea: similar to WinSum method 2 604
    //Note: k * len 在某些大数据tese case会溢出，声明为long
    public long solve(int n, int k, int len, int[] num) {
        //
        int count = 0;
        if (num == null || num.length == 0 || len > n) {
            return count;
        }

        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum += num[i];
        }
        if (sum > (long)k * len) {
            count++;
        }

        for (int i = 1; i < num.length - len + 1; i++) {
            sum = sum - num[i-1] + num[i + len - 1];
            if (sum > (long)k * len) {
                count++;
            }
        }

        return count;

    }
}
