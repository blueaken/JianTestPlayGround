package leetcode.algorithm.easy.minstack;

/**
 * Created by jshe18 on 6/27/15.
 */
public class MinStackTest {
    public static void main(String[] args){
        MinStack_WithOneStack minStack = new MinStack_WithOneStack();
        minStack.push(2);
        //minStack.push(2);

        int min, top;
        min = minStack.getMin();
        System.out.println(min);

        top = minStack.top();
        System.out.println(top);
    }
}
