package util;

import type.ParentTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParentTreeNodeUtil {
    /*
       Desc: build binary search tree from int array, where -999 indicates empty tree node
     */
    public static ParentTreeNode buildTree(int[] nodes) {
        int empty_node_ind = -999;
        if (nodes.length == 0) return null;

        List<ParentTreeNode> list = new ArrayList<>();
        for (int i : nodes) {
            if (i != empty_node_ind) {
                list.add(new ParentTreeNode(i));
            } else {
                list.add(null);
            }
        }

        for (int i = 0; i < list.size() / 2; i++) {
            ParentTreeNode cur = list.get(i);
            if (cur != null) {
                if ((2*i+1) < list.size()) {
                    cur.left = list.get(2 * i + 1);
                }
                if ((2*i+2) < list.size()) {
                    cur.right = list.get(2 * i + 2);
                }
            }
        }
        return list.get(0);
    }

    public static void printTree(ParentTreeNode root) {
        int maxLevel = getTreeDepth(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    public static int getTreeDepth(ParentTreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right));
    }

    private static void printNodeInternal(List<ParentTreeNode> nodes, int level, int maxLevel) {
        if (nodes == null || nodes.isEmpty() || isAllElementsNull(nodes)) {
            return;
        }

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<ParentTreeNode> newNodes = new ArrayList<ParentTreeNode>();
        for (ParentTreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null) {
                    System.out.print("/");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(i + i - 1);
                if (nodes.get(j).right != null) {
                    System.out.print("\\");
                } else {
                    printWhitespaces(1);
                }
                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] input = {1,-2,-999,1,-999,2};
        ParentTreeNode root = buildTree(input);
        printTree(root);
    }
}
