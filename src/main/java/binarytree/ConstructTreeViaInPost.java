package binarytree;

import type.TreeNode;

/**
 * @author jianshen
 */
public class ConstructTreeViaInPost {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0) return null;
        return rec(inorder, postorder, 0, len-1, 0, len-1);
    }

    private static TreeNode rec(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if(postEnd < 0 || postEnd>=postorder.length){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex;          // rootIndex in inorder[]
        for(rootIndex=0; rootIndex<inorder.length; rootIndex++) {
            if(inorder[rootIndex] == postorder[postEnd]){
                break;
            }
        }

        int numLeftSub = rootIndex - inStart;

        if (rootIndex > inStart){ // 锁定范围，否则会Memory out of limit!
            root.left = rec(inorder, postorder, inStart, rootIndex-1, postStart, postStart+numLeftSub-1);
        }

        if (rootIndex < inEnd){
            root.right = rec(inorder, postorder, rootIndex+1, inEnd, postStart+numLeftSub, postEnd-1);
        }

        return root;
    }

    public static void main(String[] args){
        int[] inorder = {4,10,3,1,7,11,8,2};
        int[] postorder = {4,1,3,10,11,8,2,7};

        TreeNode root = buildTree(inorder, postorder);
        System.out.println("tree building completes.");
    }
}
