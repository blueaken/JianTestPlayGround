package lintcode.binarytree;

import type.TreeNode;
import util.TreeNodeUtil;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree_LE_987 {
    class Info {
        TreeNode node;
        int row;
        int col;

        Info(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    Map<Integer, List<Info>> colList = new HashMap<>(); //col, node info list
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        //init info object
        Info node = new Info(root, 0, 0);
        traverse(node);

        //min 和 max 取开区间
        for (int i = min+1; i < max; i++) {
            List<Integer> list = new ArrayList<>();
            for (Info info : colList.get(i)) {
                list.add(info.node.val);
            }
            res.add(list);
        }
        return res;
    }

    private void traverse(Info info) {
        TreeNode node = info.node;
        int row = info.row;
        int col = info.col;

        if (node == null) {
            return;
        }

        List<Info> list = colList.getOrDefault(col, new ArrayList<>());
        list.add(info);
        //for each column, first sort by the row, if row is same then sort by the value
        Collections.sort(list, (a, b) -> {
            int diff = a.row - b.row;
            if (diff == 0) {
                diff = a.node.val - b.node.val;
            }
            return diff;
        });
        colList.put(col, list);

        int nextRow = row+1;
        int leftCol = col-1;
        int rightCol = col+1;

        min = Math.min(min, leftCol);
        max = Math.max(max, rightCol);

        Info leftInfo = new Info(node.left, nextRow, leftCol);
        traverse(leftInfo);

        Info rightInfo = new Info(node.right, nextRow, rightCol);
        traverse(rightInfo);
    }

    public static void main(String[] args) {
//        int[] input = {3,9,20,-999,-999,15,7}; //[[9], [3, 15], [20], [7]]
//        int[] input = {1,2,3,4,6,5,7}; //[[4],[2],[1,5,6],[3],[7]]
        int[] input = {3,1,4,0,2,2}; //[[0],[1],[3,2,2],[4]]
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNodeUtil.printTree(root);

        VerticalOrderTraversalOfBinaryTree_LE_987 solution = new VerticalOrderTraversalOfBinaryTree_LE_987();
        System.out.println(solution.verticalTraversal(root));

    }
}
