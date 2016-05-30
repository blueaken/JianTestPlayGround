package ninechapter_algorithm.chapter8_data_structure.implementqueueby2stacks.second;

import java.util.Stack;

/**
 * Author: blueaken
 * Date: 5/30/16 08:10
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
        if (stack2.size() != 0) {
            return stack2.pop();
        } else {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int top() {
        // write your code here
        if (stack2.size() != 0) {
            return stack2.peek();
        } else {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
}
