package ninechapter_algorithm.chapter8_data_structure.optional.stacksorting;

import java.util.Stack;

/**
 * Author: blueaken
 * Date: 6/6/16 13:21
 */
public class Solution {
    /**
     * @param stack an integer stack
     * @return void
     */
    public void stackSorting(Stack<Integer> stack) {
        // Write your code here
        Stack<Integer> helper = new Stack<>();

        while (!stack.isEmpty()){
            helper.push(stack.pop());
        }

        while (!helper.isEmpty()) {
            int cur = helper.pop();
            while (!stack.isEmpty() && cur < stack.peek()) {
                helper.push(stack.pop());
            }
            stack.push(cur);
        }
    }
}
