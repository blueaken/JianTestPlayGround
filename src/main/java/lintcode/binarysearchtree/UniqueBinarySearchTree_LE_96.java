package lintcode.binarysearchtree;

public class UniqueBinarySearchTree_LE_96 {
    //ref - Tushor's video - https://www.youtube.com/watch?v=RUB5ZPfKcnY
    public int numTrees(int n) {
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                res[i] += res[j] * res[i-j-1];
            }
        }
        return res[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTree_LE_96 solution = new UniqueBinarySearchTree_LE_96();
        System.out.println(solution.numTrees(5));
    }
}
