package leetcode.easy.minstack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jshe18 on 6/25/15.
 */
public class MinStack_WithArrayList {
    List<Integer> stack = new ArrayList<Integer>();
    List<Integer> minStack = new ArrayList<Integer>();

    public void push(int x){
        if (minStack.isEmpty() || (x <= getMin())){
            minStack.add(x);
        }
        stack.add(x);
    }

    public int pop(){
        if (top() == getMin()){
            minStack.remove(minStack.size()-1);
        }
        return stack.remove(stack.size() - 1);
    }

    public int top(){
        return stack.size() == 0 ? Integer.MAX_VALUE : stack.get(stack.size()-1);
    }

    public int getMin(){
        return minStack.size() == 0 ? Integer.MAX_VALUE : minStack.get(minStack.size()-1);
    }
}
