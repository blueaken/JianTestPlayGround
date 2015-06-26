package leetcode.easy.minstack;

import java.util.Stack;

/**
 * Created by jshe18 on 6/25/15.
 */
public class MinStack_WithBuiltInStack {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

   public void push(int x){
       if (minStack.empty() || (x <= minStack.peek())){
           minStack.push(x);
       }
       stack.push(x);
   }

   public int pop(){
       if (stack.peek().equals(minStack.peek())){
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
