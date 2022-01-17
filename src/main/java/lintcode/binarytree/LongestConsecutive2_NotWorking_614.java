package lintcode.binarytree;

import type.ParentTreeNode;
import util.ParentTreeNodeUtil;

public class LongestConsecutive2_NotWorking_614 {
    int res = 0;
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    //Idea: 在longestConsecutive(595)的基础上，保存parent节点的纪录，并同时向左右父3个方向寻找路径, 但试下来有2个问题
    //1. 需要ParentTreeNode类(472中使用)才能记录每个节点的父节点
    //2. 回溯时需要防止出现往回遍历，需要在3个方向都进行检查，但这样的话又和题目要求矛盾
    //结论，本题不能使用3个方向遍历的方法，而使用分别统计向上和向下2方向的方法
    public int longestConsecutive2(ParentTreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        dfs (root, null, 1);
        return res;
    }

    private void dfs (ParentTreeNode node, ParentTreeNode parent, int path) {
        if (node == null) {
            return;
        }

        res = Math.max(res, path);

        // 类似图遍历算法，往 left、right、parent 三个方向遍历，
        // 通过判断 left或者right 指针是否等于 parent 来判断是否出现往回遍历的情形
        // 注意允许当前结点指针往上遍历，不然不能覆盖子节点回到根节点情况
        if (parent != null && node.parent != parent) {
            if ((parent.val - node.val) == 1) {
                dfs (parent, node, path + 1);
            }
        }
        if (node.left != null && node.left != parent) {
            if ((node.left.val - node.val) == 1) {
                dfs (node.left, node, path + 1);
            } else {
                dfs (node.left, node, 1);
            }
        }
        if (node.right != null && node.right != parent) {
            if ((node.right.val - node.val) == 1) {
                dfs (node.right, node, path + 1);
            } else {
                dfs (node.right, node, 1);
            }
        }

    }

    public static void main(String[] args) {
//        int[] input = {1,-999,3,-999,-999,2,4,-999,-999,-999,-999,-999,-999,-999,5};
        int[] input = {1,2,0,3};
        ParentTreeNode root = ParentTreeNodeUtil.buildTree(input);
        ParentTreeNodeUtil.printTree(root);

        LongestConsecutive2_NotWorking_614 solution = new LongestConsecutive2_NotWorking_614();
        System.out.println(solution.longestConsecutive2(root));
    }

}
