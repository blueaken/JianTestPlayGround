package ninechapter_algorithm.chapter8_data_structure.minstack;

import java.util.Stack;

/**
 * Author: blueaken
 * Date: 4/29/16 14:53
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        // do initialize if necessary
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty() || minStack.peek() >= number) {
            minStack.push(number);
        }
    }

    public int pop() {
        // write your code here
        int ret = stack.pop();
        if (minStack.peek() == ret) {
            minStack.pop();
        }
        return ret;
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}
