package ninechapter_algorithm.chapter8_data_structure.implementqueueby2stacks;

import java.util.Stack;

/**
 * Author: blueaken
 * Date: 4/30/16 10:12
 */
public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
        // do initialization if necessary
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int top() {
        // write your code here
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }
}
