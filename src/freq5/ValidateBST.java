package freq5;

import type.TreeNode;

/**
 * @author jianshen
 */
public class ValidateBST {
    //level 3
    /*
    * 一开始想到了递归，但没想到用上下限的办法，结果非常麻烦, 而且不能判断parent的root值。改成用上下限后代码很简洁清晰。
     */
    public static void main(String[] args){
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(27);

        System.out.println(isValidBST(node));
    }

    public static boolean isValidBST(TreeNode root) {
        return isBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBSTRec(TreeNode root, int left, int right) {
        if(root == null) {
            return true;
        }
        if(root.val <= left || root.val >= right) {
            return false;
        }

        return isBSTRec(root.left, left, root.val) && isBSTRec(root.right, root.val, right);
    }

    // first attack
//    public static boolean isValidBST(TreeNode root) {
//        if (root == null) return true;
//
//        if ((root.left != null) && (root.right != null)){
//            return (root.left.val < root.val && root.val < root.right.val && isValidBST(root.left) && isValidBST(root.right));
//        }
//
//        if (root.left != null && root.right == null) {
//            return (root.left.val < root.val && isValidBST(root.left));
//        }
//
//        if (root.left == null && root.right != null) {
//            return (root.val < root.right.val && isValidBST(root.right));
//        }
//
//        return true;
//
//    }
}
