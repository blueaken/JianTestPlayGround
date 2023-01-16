package lintcode.math.bitmanipulation;

public class PowerOfTwo_LE_231 {
    /**
     1.16.2021
     ref东哥post，利用power of 2的数只有一个位是1，并且n&(n-1)操作会把最后一位1清0
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n&(n-1)) == 0;
    }
}
