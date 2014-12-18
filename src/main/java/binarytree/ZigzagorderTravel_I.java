package binarytree;

import type.TreeNode;

import java.util.*;

/**
 * @author jianshen
 */
public class ZigzagorderTravel_I {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        List<Integer> level = new ArrayList<Integer>();
        TreeNode node;

        int currentLevel = 1;
        int nextLevel = 0;
        boolean isOddLevel = false;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.size() > 0){
            node = queue.remove();
            level.add(node.val);
            currentLevel --;

            if (node.left != null) {
                queue.add(node.left);
                nextLevel ++;
            }

            if (node.right != null) {
                queue.add(node.right);
                nextLevel ++;
            }

            if (currentLevel == 0){
                currentLevel = nextLevel;
                nextLevel = 0;
                isOddLevel = !isOddLevel;
                if (!isOddLevel){
/*           my first try           */
//                    List<Integer> level_reverseOrder = new ArrayList<Integer>();
//                    for (int i = level.size()-1; i>=0; i--){
//                        level_reverseOrder.add(level.get(i));
//                    }
//                    level = level_reverseOrder;

/*           more classic way       */
                    Collections.reverse(level);
                }
                result.add(level);
                level = new ArrayList<Integer>();
            }
        }

        return result;
    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(27);

        List<List<Integer>> result = zigzagLevelOrder(node);
        System.out.println(result);
    }
}
