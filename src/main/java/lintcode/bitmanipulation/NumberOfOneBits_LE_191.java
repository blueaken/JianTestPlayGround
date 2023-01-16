package lintcode.bitmanipulation;

public class NumberOfOneBits_LE_191 {
    /**
     1.16.2023
     ref东哥 post, use n&(n-1) 消除最后一位1的性质
     */
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
