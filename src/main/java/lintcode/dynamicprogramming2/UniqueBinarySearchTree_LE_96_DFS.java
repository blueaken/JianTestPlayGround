package lintcode.dynamicprogramming2;

public class UniqueBinarySearchTree_LE_96_DFS {
    //ref - Tushor's video - https://www.youtube.com/watch?v=RUB5ZPfKcnY
    public int numTrees(int num) {
        if (num < 2) {
            return 1;
        }

        int left, right;
        int sum = 0;
        for (int key = 1;  key <= num; key++) {
            left = numTrees(key - 1);
            right = numTrees(num - key);
            sum += left * right;
        }

        return sum;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTree_LE_96_DFS solution = new UniqueBinarySearchTree_LE_96_DFS();
        System.out.println(solution.numTrees(5));
    }
}
