package lintcode.binarytree;

import java.util.Stack;

/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */
abstract class NodeFM {
    public abstract int evaluate();

    // define your fields here
    public static NodeFM create(String val) {
        switch (val) {
            case "+":
                return new AddNode();
            case "-":
                return new SubtractNode();
            case "*":
                return new MultipleNode();
            case "/":
                return new DivideNode();
            default:
                return new NumerateNode(val);
        }
    }
}

abstract class OperatorNode extends NodeFM {
    protected NodeFM left;
    protected NodeFM right;

    public void setLeft(NodeFM left) {
        this.left = left;
    }
    public void setRight(NodeFM right) {
        this.right = right;
    }
}

class AddNode extends OperatorNode {
    @Override
    public int evaluate() {
        return left.evaluate() + right.evaluate();
    }
}

class SubtractNode extends OperatorNode {
    @Override
    public int evaluate() {
        return left.evaluate() - right.evaluate();
    }
}

class MultipleNode extends OperatorNode {
    @Override
    public int evaluate() {
        return left.evaluate() * right.evaluate();
    }
}

class DivideNode extends OperatorNode {
    @Override
    public int evaluate() {
        return left.evaluate() / right.evaluate();
    }
}

class NumerateNode extends NodeFM {
    String val;

    NumerateNode (String val) {
        this.val = val;
    }

    @Override
    public int evaluate() {
        return Integer.valueOf(val);
    }
}

/*
    - ref solution link https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function/discuss/933995/Java-Stack-%2B-OOP
    - build the binary tree with a stack
    - dfs the tree and evaluate the result
    - For the follow up question -
      Follow up: Could you design the expression tree such that it is more modular? For example, is your design able to support additional operators without making changes to your existing evaluate implementation?
    - refactor the code with factory mode to make the solution more modular?
    - ref - https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function/discuss/1209901/Java-Factory-method-pattern
 */
public class BuildExpressionTreeWithEvaluateFun_LE_1628_FactoryPattern {
    NodeFM buildTree(String[] postfix) {
        Stack<NodeFM> stack = new Stack<>();
        for (String s : postfix) {
            NodeFM node = NodeFM.create(s);
            if (node instanceof NumerateNode) {
                stack.push(node);
            } else if (node instanceof OperatorNode) {
                OperatorNode n = (OperatorNode) node;
                n.setRight(stack.pop());
                n.setLeft(stack.pop());
                stack.push(n);
            } else {
                throw new IllegalStateException("node should be instance of OperatorNode or NumerateNode!");
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

    public static void main(String[] args) {
        BuildExpressionTreeWithEvaluateFun_LE_1628_FactoryPattern solution = new BuildExpressionTreeWithEvaluateFun_LE_1628_FactoryPattern();
        String[] postfix = {"3", "4", "+", "2", "*", "7", "/"};//2
        NodeFM expTree = solution.buildTree(postfix);
        System.out.println(expTree.evaluate());
    }
}
