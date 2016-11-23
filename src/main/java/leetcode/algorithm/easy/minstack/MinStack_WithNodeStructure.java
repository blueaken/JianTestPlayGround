package leetcode.algorithm.easy.minstack;

import type.MinStackNode;

/**
 * Created by jshe18 on 6/25/15.
 */
public class MinStack_WithNodeStructure {

    MinStackNode top = null;

   public void push(int x){
       MinStackNode node = new MinStackNode(x);
       if (top != null){
           if (x < top.getMin()){
               node.setMin(x);
           } else {
               node.setMin(top.getMin());
           }
           node.setNext(top);
       } else {
           node.setMin(x);
       }
       top = node;
   }

   public int pop(){
       if (top != null){
           int val = top.getVal();
           top = top.getNext();
           return val;
       }else{
           return Integer.MAX_VALUE;
       }
   }

   public int top(){
       if (top != null){
           return top.getVal();
       }else{
           return Integer.MAX_VALUE;
       }
   }

   public int getMin(){
       if (top != null){
           return top.getMin();
       }else{
           return Integer.MAX_VALUE;
       }
   }
}

