package lintcode.binarytree;

import type.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal_LE_106 {
    /*
        11.07.2022
        ref labuladong post, similar to 105
        - solve with 遍历
        - use HashMap to avoid traverse inorder array each time
    */
    Map<Integer, Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }

        return helper(inorder, 0, n-1, postorder, 0, n-1);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int val = postorder[postEnd];
        int inIdx = inMap.get(val);
        int leftLen = inIdx - inStart;

        TreeNode node = new TreeNode(val);
        node.left = helper(inorder, inStart, inIdx-1, postorder, postStart, postStart + leftLen-1);
        node.right = helper(inorder, inIdx+1, inEnd, postorder, postStart+leftLen, postEnd-1);

        return node;
    }
}
