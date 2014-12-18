package level3;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jianshen
 */
public class InorderTravel_I {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack stack = new Stack();

        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                root = (TreeNode)stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }

        return result;
    }

    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);

        List<Integer> result = inorderTraversal(treeNode);
        for (Integer i: result){
            System.out.println(i);
        }
    }
}
