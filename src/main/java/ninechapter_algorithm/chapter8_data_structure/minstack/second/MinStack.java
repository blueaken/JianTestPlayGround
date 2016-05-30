package ninechapter_algorithm.chapter8_data_structure.minstack.second;

import java.util.Stack;

/**
 * Author: blueaken
 * Date: 5/30/16 07:57
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;

    public MinStack() {
        // do initialize if necessary
        this.stack = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if (min.size() == 0 || number <= min.peek()) {
            min.push(number);
        }
    }

    public int pop() {
        // write your code here
        int val = stack.pop();
        if (val == min.peek()) {
            min.pop();
        }
        return val;
    }

    public int min() {
        // write your code here
        return min.peek();
    }
}
