package binarytree;

import type.TreeNode;

/**
 * @author jianshen
 */
public class ConstructTreeViaPreIn {
    //a useful one, but a little tricky.
    //see analysis on http://blog.csdn.net/fightforyourdream/article/details/16914595 AND
    //http://leetcode.com/2011/04/construct-binary-tree-from-inorder-and-preorder-postorder-traversal.html
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0) return null;

        return rec(preorder, inorder, 0, len, 0, len);
    }

    private static TreeNode rec(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if (preStart >= preorder.length) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIndex = 0;
        for (int i=inStart; i<=inEnd; i++){
            if (inorder[i] == preorder[preStart]) {
                rootIndex = i;
                break;
            }
        }

        int len = rootIndex - inStart; //calc the number of left sub
        if (rootIndex > inStart){
            root.left = rec(preorder, inorder, preStart+1, preStart+len, inStart, rootIndex-1);
        }
        if (rootIndex < inEnd){
            root.right = rec(preorder, inorder, preStart+len+1, preEnd, rootIndex+1, inEnd);
        }

        return root;
    }

    public static void main(String[] args){
        int[] preorder = {7,10,4,3,1,2,8,11};
        int[] inorder = {4,10,3,1,7,11,8,2};

        TreeNode root = buildTree(preorder, inorder);
        System.out.println("tree building completes.");
    }
}
