package leetcode.algorithm.easy.minstack.second;

import java.util.Stack;

/**
 * Created by jshe18 on 11/5/15.
 */
public class Solution {
    /*
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
     */

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x){
        if (minStack.empty() || minStack.peek()>=x){
            minStack.push(x);
        }
        stack.push(x);
    }

    public int pop(){
        if (!minStack.empty() && minStack.peek().equals(stack.peek())){
            minStack.pop();
        }
        return stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }
}
