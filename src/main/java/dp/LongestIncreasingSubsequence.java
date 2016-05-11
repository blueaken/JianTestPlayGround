package dp;

/**
 * @author jianshen
 */
/* LIS 的动态规划方式实现*/
public class LongestIncreasingSubsequence {
    /*
    * like the explanation here: http://www.slyar.com/blog/poj-2533-cpp.html
    *
    * Slyar:属于简单的经典的DP，求最长上升子序列(LIS)。先研究了O(n^2)的思路。

     令A[i]表示输入第i个元素，D[i]表示从A[1]到A[i]中以A[i]结尾的最长子序列长度。对于任意的0 <  j <= i-1，如果A(j) < A(i)，则A(i)可
     以接在A(j)后面形成一个以A(i)结尾的新的最长上升子序列。对于所有的 0 <  j <= i-1，我们需要找出其中的最大值。

    DP状态转移方程:

    D[i] = max{1, D[j] + 1} (j = 1, 2, 3, ..., i-1 且 A[j] < A[i])

    解释一下这个方程，i， j在范围内:
    如果 A[j] < A[i] ，则D[i] = max{D[j] + 1}
    如果 A[j] >= A[i] ，则D[i] = 1
     */
    public static void main(String[] args){
//        int[] input = {1, 7, 3, 5, 9, 4, 8};
        int[] input = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println("LIS length of the input array is: " + LIS(input));
    }

    /* lis() returns the length of the longest increasing subsequence in input[] */
    static int LIS(int[] input){
        int len = input.length;
        if (len == 0){
            System.out.println("Input array is empty.");
        }

        /* d[i]表示以a[i]结尾的最长子序列长度 */
        int[] d = new int[len];
        int max = 0;

        /* Initialize LIS values for all indexes */
        for (int i=0; i<len; i++){
            d[i] = 1;
        }

        for (int i=1; i<len; i++){
            for (int j=0; j<i; j++){
                if (input[i]>input[j] && (d[i]<d[j]+1)){
                    d[i] = d[j] + 1;
                }
            }
            // record the max each iteration
            if (d[i] > max){
                max = d[i];
            }
        }

        return max;
    }
}
