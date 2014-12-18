package level1;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 7/8/14 6:13 下午
 */
public class MaxDepthBinaryTree {
    public static int maxDepth(TreeNode root) {
        if (root == null ) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        if (leftHeight >= rightHeight){
            return leftHeight+1;
        } else {
            return rightHeight+1;
        }
    }

    public static void main(String[] args){
        TreeNode oneHeightRoot = new TreeNode(5);
        System.out.println("One height tree's height is: " + maxDepth(oneHeightRoot));

        TreeNode TwoHeightTreeRoot = new TreeNode(5);
        TwoHeightTreeRoot.left = new TreeNode(3);
        System.out.println("Two height tree's height is: " + maxDepth(TwoHeightTreeRoot));

        TreeNode ThreeHeightTreeRoot = new TreeNode(5);
        ThreeHeightTreeRoot.left = new TreeNode(3);
        ThreeHeightTreeRoot.right = new TreeNode(7);
        ThreeHeightTreeRoot.left.left = new TreeNode(2);
        System.out.println("Three height tree's height is: " + maxDepth(ThreeHeightTreeRoot));
    }

}
