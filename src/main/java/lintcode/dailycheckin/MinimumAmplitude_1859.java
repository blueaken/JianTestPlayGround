package lintcode.dailycheckin;

import java.util.Arrays;

public class MinimumAmplitude_1859 {
    /**
     * @param A: a list of integer
     * @return: Return the smallest amplitude
     */
    //Idea: 对长度小于4的数组，只要将数字调整为一个就可以得到最小振幅0；对长度大于4的情况，
    //      由于改变数字要使得振幅减少，所以我们倾向于改变最大值或者最小值，所以我们先对数
    //      组排序。比较4种情况：1. 删除最左边三个数；2.删除最右边三个数；3. 左边删一个，右
    //      边删二个；4.左边删二个，右边删一个。得出振幅最小的一个。
    //      ref - https://blog.csdn.net/qq_46105170/article/details/105021782
    //      要想清楚这点，并不算Easy级别。
    public int MinimumAmplitude(int[] A) {
        // write your code here
        if (A == null || A.length <= 4) {
            return 0;
        }

        Arrays.sort(A);
        int rPos = A.length - 1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            min = Math.min(min, A[rPos - (3 - i)] - A[i]);
        }
        return min;
    }
}
