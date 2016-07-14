package leetcode.algorithm.easy.minstack.second;

import java.util.Stack;

/**
 * Created by jshe18 on 11/6/15.
 */
//this is medium to hard difficult level

// although my solution cannot AC, but from the test result my solution is correct
// the 1st one stack solution has a bug/or sth I cannot understand on pop() - it returns the updated min instead the
// the stack value. In interview, I think it is fine present my solution, and communicate with the thoughts behind.
public class Solution_OneStack {
    private Stack<Long> stack = new Stack<>();
    private long min = Long.MAX_VALUE;

    public void push(int x){
        if (stack.isEmpty()){
            min = x;
            stack.push(0L);
        }else {
            stack.push(x-min);
            if (x<min){
                min = x;
            }
        }
    }

    public int pop(){
        if (stack.empty()){
            return Integer.MAX_VALUE;
        }else{
            long diff = stack.pop();
            if (diff<0){
                min = min - diff;
            }
            return (int)(diff + min);
        }
    }

    public int top(){
        if (stack.empty()){
            return Integer.MAX_VALUE;
        }else{
            long val = stack.peek() + min;
            return (int)val;
        }
    }

    public int getMin(){
        return (int)min;
    }

}
