package lintcode.binarytree;

import java.util.ArrayList;
import java.util.List;

import type.TreeNode;
import util.TreeNodeUtil;

public class RecoverBST_LE_99 {
    /*
    - ref solution link and break the problem into 3 subproblems to solve:
    - 1. inorder traverse and get current list - O(N)
    - 2. find the 2 elements to swap - O(N)
    - 3. recover the tree - O(N)
    - ref: https://leetcode.com/problems/recover-binary-search-tree/solution/
    - Time - O(N), Space - O(N)
    */
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);
        int[] swap = findTwoSwapped(nums);
        recover(root, swap[0], swap[1], 2);
    }

    private void recover(TreeNode root, int x, int y, int count) {
        if (root == null) {
            return;
        }

        if (root.val == x || root.val == y) {
            if (root.val == x) {
                root.val = y;
            } else {
                root.val = x;
            }
            count--;
        }
        if (count == 0) {
            return;
        }
        recover(root.left, x, y, count);
        recover(root.right, x, y, count);
    }

    private int[] findTwoSwapped(List<Integer> nums) {
        int[] res = new int[2];

        boolean findFirst = false;
        for (int i = 0; i < nums.size() - 1; i ++) {
            if (nums.get(i+1) < nums.get(i)) {
                res[1] = nums.get(i+1);
                if (!findFirst) {
                    res[0] = nums.get(i);
                    findFirst = true;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }

        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }

    public static void main(String[] args) {
        RecoverBST_LE_99 solution = new RecoverBST_LE_99();
        int[] input = {3,1,4,-999,-999,2}; //case when the 2 swapped node are not adjacent
//        int[] input = {1,3,-999,-999,2}; //case when the 2 swapped node are adjacent
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNodeUtil.printTree(root);
        System.out.println("===========================");
        solution.recoverTree(root);
        TreeNodeUtil.printTree(root);
    }
}
