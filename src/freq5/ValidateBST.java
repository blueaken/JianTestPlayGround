package freq5;

import type.TreeNode;

/**
 * @author jianshen
 */
public class ValidateBST {
    //level 3
    public static void main(String[] args){
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(27);

        System.out.println(isValidBST(node));
    }

    public static boolean isValidBST(TreeNode root) {

    }
}
