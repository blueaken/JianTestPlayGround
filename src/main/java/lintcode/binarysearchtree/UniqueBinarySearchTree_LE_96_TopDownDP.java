package lintcode.binarysearchtree;

public class UniqueBinarySearchTree_LE_96_TopDownDP {
    /**
     11.11.2022
     ref 东哥 post
     - solve with top down DP with mem table optimization
     */
    int[][] mem;
    public int numTrees(int n) {
        mem = new int[n+1][n+1];
        return count(1, n);
    }

    //统计lo..hi闭区间的所有BST数量
    private int count(int lo, int hi) {
        //base case - note empty node is still a BST
        if (lo > hi) {
            return 1;
        }

        if (mem[lo][hi] != 0) {
            return mem[lo][hi];
        }

        int res = 0;
        for (int i = lo; i <= hi; i++) {
            int left = count(lo, i-1);
            int right = count(i+1, hi);
            res += left * right;
        }
        mem[lo][hi] = res;
        return mem[lo][hi];
    }
}
