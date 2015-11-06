package leetcode.easy.minstack.second;

import type.MinStackNode;

/**
 * Created by jshe18 on 11/6/15.
 */
public class Solution_MinStackNode {
     /*
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
     */

    MinStackNode top = null;

    public void push(int x){
        MinStackNode node = new MinStackNode(x);
        if (top==null){
            node.setMin(x);
        }else {
            node.setMin(top.getMin()>x ? x : top.getMin());
            node.setNext(top);
        }
        top = node;
    }

    public int pop(){
        if (top!=null) {
            int val = top.getVal();
            top = top.getNext();
            return val;
        }else{
            return Integer.MAX_VALUE;
        }
    }

    public int top(){
        return top.getVal();
    }

    public int getMin(){
        return top.getMin();
    }
}
