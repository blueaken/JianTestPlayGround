package lintcode.binarytree;

import type.TreeNode;
import util.TreeNodeUtil;

public class IsTweakedIdentical_470 {
    /**
     * @param a: the root of binary tree a.
     * @param b: the root of binary tree b.
     * @return: true if they are tweaked identical, or false.
     */
    //Idea: 判断了边界条件后，只要a节点左子树和b节点任一子树相等并且a节点右子树和b节点剩余的子树相等即可
    public static boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        // write your code here
        if (a == null && b == null) return true;
        if (a == null || b == null || a.val != b.val) return false;

        return (isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right))
                || (isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left));
    }

    public static void main(String[] args) {
        int[] inputA = {1,2,2,3,-999,-999,3};
        int[] inputB = {1,2,5,3,-999,-999,5};
        TreeNode rootA = TreeNodeUtil.buildTree(inputA);
        TreeNode rootB = TreeNodeUtil.buildTree(inputB);

        TreeNodeUtil.printTree(rootA);
        TreeNodeUtil.printTree(rootB);

        System.out.println(isTweakedIdentical(rootA, rootB));

    }
}
