package lintcode.binarytree;

import type.TreeNode;
import util.TreeNodeUtil;

public class LongestConsecutive2_614 {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    //Idea: Ref - https://www.jianshu.com/p/3e28c47e53ee
    public int longestConsecutive2(TreeNode root) {
        // write your code here
        return dfs (root).max_length;
    }

    private ResultType dfs (TreeNode node) {
        if (node == null) {
            return new ResultType(0,0,0);
        }

        ResultType left = dfs(node.left);
        ResultType right = dfs(node.right);

        //每一轮递归这3个值都要重置
        int up = 0;
        int down = 0;
        int max_length = 1;

        // node.left(node.right) 的 up 和 down 同时只能出现一种
        // 满足第一条if必然不满足第二条
        // 满足第三条语句必然不满足第四条
        // node.left 和 node.right 的 up(或down) 同时只能有一个赋值给 up(down)
        // 因为会被较大的 up 值把之前较小的 up 值覆盖掉
        // 较大的 down 值会把之前较小的 down 值覆盖掉
        // 所以只会有两种情况：
        // 1. 左右两边一个是 up，一个是 down
        // 2. 两边同是 up 或 down，较大(小)的将前一个覆盖
        //   此时只有一边提供了值，另一边值为 0
        // 简言之，下面四个 if 最多执行 2 句
        if (node.left != null && (node.left.val - node.val) == 1) {
            up = Math.max(up, left.max_up + 1);
        }
        if (node.left != null && (node.val - node.left.val) == 1) {
            down = Math.max(down, left.max_down + 1);
        }
        if (node.right != null && (node.right.val - node.val) == 1) {
            up = Math.max(up, right.max_up + 1);
        }
        if (node.right != null && (node.val - node.right.val) == 1) {
            down = Math.max(down, right.max_down + 1);
        }

        // 此时的 max_length 代表不经过 root 结点的左右子树各自 max_length 中的较大值
        // 然后和经过 root 计算出来的长度比较看哪个大
        max_length = Math.max(left.max_length, right.max_length);

        //经过 root 计算出来的长度
        int length = up + 1 + down;
        length = Math.max(length, max_length);
        return new ResultType(length, up, down);
    }

    public static void main(String[] args) {
//        int[] input = {1,-999,3,-999,-999,2,4,-999,-999,-999,-999,-999,-999,-999,5};
        int[] input = {1,2,0,3};
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNodeUtil.printTree(root);

        LongestConsecutive2_614 solution = new LongestConsecutive2_614();
        System.out.println(solution.longestConsecutive2(root));
    }
}

class ResultType {
    int max_length;
    int max_up;
    int max_down;
    ResultType (int length, int up, int down) {
        this.max_length = length;
        this.max_up = up;
        this.max_down = down;
    }
}
