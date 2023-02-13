package lintcode.stack;

import java.util.Stack;

public class MinStack_LE_155 {
    /**
     2.13.2023
     - redo with 2 stacks
     */

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack_LE_155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.size() == 0 || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.size() > 0) {
            int val = stack.pop();
            if (minStack.peek() == val) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (stack.size() == 0) {
            return -1;
        } else {
            return stack.peek();
        }
    }

    public int getMin() {
        if (minStack.size() > 0) {
            return minStack.peek();
        } else {
            return -1;
        }
    }
}
