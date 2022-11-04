package lintcode.binarytree;

public class PopulatingNextRightPointersInEachNode_LE_116 {
    /*
        11.04.2022
        ref东哥post - solve by traverse, note the requirement is to link neighbor nodes of different parent nodes as well
    */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        traverse(root.left, root.right);
        return root;
    }

    private void traverse(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        //preorder position
        node1.next = node2;

        //link sibling nodes of the same parent
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);

        //link sibling nodes of the different parent
        traverse(node1.right, node2.left);
        return;
    }
}


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

