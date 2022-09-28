package lintcode.design;

import java.util.Stack;

/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */


/*
    P2
*/

abstract class Node {

    public static Node create(String val) {
        switch (val) {
            case "+":
                return new AddNode();
            case "-":
                return new SubtractNode();
            case "*":
                return new MultiplyNode();
            case "/":
                return new DivideNode();
            default:
                return new NumericNode(val);
        }
    }

    public abstract int evaluate();
    // define your fields here
};

abstract class OperatorNode extends Node {
    Node left;
    Node right;

    void setLeft(Node left) {
        this.left = left;
    }

    void setRight(Node right) {
        this.right = right;
    }

    // OperatorNode(NumericNode left, NumericNode right) {
    //     this.left = left;
    //     this.right = right;
    // }
}

class AddNode extends OperatorNode {
    public int evaluate() {
        return left.evaluate() + right.evaluate();
    }
}

class SubtractNode extends OperatorNode {
    public int evaluate() {
        return left.evaluate() - right.evaluate();
    }
}

class MultiplyNode extends OperatorNode {
    public int evaluate() {
        return left.evaluate() * right.evaluate();
    }
}

class DivideNode extends OperatorNode {
    public int evaluate() {
        return left.evaluate() / right.evaluate();
    }
}

class NumericNode extends Node {
    String val;

    NumericNode(String val) {
        this.val = val;
    }

    public int evaluate() {
        return Integer.valueOf(val);
    }
}

public class BuildExpressionTreeWithEvaluateFun_LE_1628_FactoryPattern_P2 {
    Node buildTree(String[] postfix) {
        Stack<Node> stack = new Stack<>();
        for (String val : postfix) {
            Node node = Node.create(val);
            if (node instanceof NumericNode) {
                stack.push(node);
            } else if (node instanceof OperatorNode) {
                OperatorNode n = (OperatorNode)node;
                n.setRight(stack.pop());
                n.setLeft(stack.pop());
                stack.push(n);
            }
        }
        return stack.pop();
    }

    /**
     * Your TreeBuilder object will be instantiated and called as such:
     * TreeBuilder obj = new TreeBuilder();
     * Node expTree = obj.buildTree(postfix);
     * int ans = expTree.evaluate();
     */
}
