package leetcode.algorithm.easy.minstack;

import java.util.Stack;

/**
 * Created by jshe18 on 6/25/15.
 */
public class MinStack_WithOneStack {

    long min; //long is used to prevent overflow
    Stack<Long> stack = new Stack<Long>();

   public void push(int x){
       if (stack.isEmpty()){
           min = x;
       }

       stack.push(x - min); //could be negative if min needs change
       if (x < min) {
           min = x;
       }
   }

   public int pop(){
       long pop = stack.pop();
       if (pop > 0){
           return (int)(pop+min);
       }else{
           min = min-pop; //increase the min
           return (int)min;
       }
   }

   public int top(){
       long peek = stack.peek();
       if (peek > 0){
           return (int)(peek+min);
       }else{
           return (int)min;
       }
   }

   public int getMin(){
       return (int)min;
   }
}
