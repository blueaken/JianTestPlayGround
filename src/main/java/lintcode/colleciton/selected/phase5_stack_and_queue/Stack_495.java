package lintcode.colleciton.selected.phase5_stack_and_queue;

import java.util.ArrayList;
import java.util.List;

public class Stack_495 {
    /*
     * @param x: An integer
     * @return: nothing
     */

    List<Integer> stack = new ArrayList<Integer>();

    public void push(int x) {
        // write your code here
        stack.add(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        stack.remove(stack.size()-1);
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        return stack.size() == 0 ? Integer.MAX_VALUE : stack.get(stack.size()-1);
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return stack.size() == 0;
    }
}
