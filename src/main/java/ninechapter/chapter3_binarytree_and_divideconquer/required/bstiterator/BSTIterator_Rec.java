package ninechapter.chapter3_binarytree_and_divideconquer.required.bstiterator;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 2/29/16 11:32 AM
 */
public class BSTIterator_Rec {
    private TreeNode root;
    private List<TreeNode> list = new ArrayList<>();
    private int cur = 0;

    //@param root: The root of binary tree.
    public BSTIterator_Rec(TreeNode root) {
        // write your code here
        this.root = root;

        rec(root, list);
    }

    private void rec(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }

        rec(node.left, list);
        list.add(node);
        rec(node.right, list);
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        if (list == null) {
            return false;
        }
        return cur < list.size();
    }

    //@return: return next node
    public TreeNode next() {
        // write your code here
        return list.get(cur++);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);

        BSTIterator_Rec i = new BSTIterator_Rec(root);
        while (i.hasNext()) {
            System.out.println(i.next().val);
        }
    }
}
