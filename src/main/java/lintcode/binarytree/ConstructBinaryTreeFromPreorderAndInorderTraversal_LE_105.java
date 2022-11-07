package lintcode.binarytree;

import type.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_LE_105 {
    /*
        11.07.2022
        ref labuladong post
        - solve with 遍历
        - use HashMap to avoid traverse inorder array each time
    */
    Map<Integer, Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }

        return helper(preorder, 0, n-1, inorder, 0, n-1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd,
                            int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int val = preorder[preStart];
        int inOrderIdx = inMap.get(val);

        int leftLen = inOrderIdx - inStart;
        TreeNode node = new TreeNode(val);
        node.left = helper(preorder, preStart+1, preStart+leftLen,
                inorder, inStart, inOrderIdx-1);
        node.right = helper(preorder, preStart+leftLen+1, preEnd,
                inorder, inOrderIdx+1, inEnd);
        return node;
    }
}
