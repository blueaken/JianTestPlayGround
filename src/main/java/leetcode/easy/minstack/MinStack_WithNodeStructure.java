package leetcode.easy.minstack;

/**
 * Created by jshe18 on 6/25/15.
 */
public class MinStack_WithNodeStructure {

    Node top = null;

   public void push(int x){
       Node node = new Node(x);
       if (top != null){
           if (x < top.min){
               node.min = x;
           } else {
               node.min = top.min;
           }
           node.next = top;
       } else {
           node.min = x;
       }
       top = node;
   }

   public int pop(){
       if (top != null){
           int val = top.val;
           top = top.next;
           return val;
       }else{
           return Integer.MAX_VALUE;
       }
   }

   public int top(){
       if (top != null){
           return top.val;
       }else{
           return Integer.MAX_VALUE;
       }
   }

   public int getMin(){
       if (top != null){
           return top.min;
       }else{
           return Integer.MAX_VALUE;
       }
   }
}

class Node {
    int val;
    int min;
    Node next;

    Node (int v) {
        val = v;
    }
}
