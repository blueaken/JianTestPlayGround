package lintcode.binarytree;

import type.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_LE_105_P1 {
    /*
        02.20.2023
        P2 ref labuladong template
        - use HashMap to avoid travse inorder array each time
    */
    Map<Integer, Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }

        return helper(preorder, 0, n-1, inorder, 0, n-1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        int rootIdx = inMap.get(rootVal);
        int leftLen = rootIdx - inStart;

        TreeNode node = new TreeNode(rootVal);
        node.left = helper(preorder, preStart+1, preStart + leftLen, inorder, inStart, rootIdx-1);
        node.right = helper(preorder, preStart + leftLen + 1, preEnd, inorder, rootIdx+1, inEnd);
        return node;
    }
}
