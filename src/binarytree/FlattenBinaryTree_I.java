package binarytree;

import type.TreeNode;

import java.util.Stack;

/**
 * @author jianshen
 */
public class FlattenBinaryTree_I {
    public static void flatten(TreeNode root) {
        if (root == null) return;

        Stack stack = new Stack();
        stack.push(root);

        TreeNode node;
        TreeNode latestParent = null;
        while(stack.size()>0){
            node = (TreeNode)stack.pop();
            if (latestParent == null){
                latestParent = node;
            } else{
                latestParent.right = node;
                latestParent.left = null;
                latestParent = latestParent.right;
            }

            //preOrder the rest of the tree
            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }
        }

        return;
    }

    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);

        flatten(treeNode);

        while (treeNode != null){
            System.out.println(treeNode.val);
            treeNode = treeNode.right;
        }
    }

}
