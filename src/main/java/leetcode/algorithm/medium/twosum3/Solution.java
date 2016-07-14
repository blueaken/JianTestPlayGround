package leetcode.algorithm.medium.twosum3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jshe18 on 8/7/15.
 */
public class Solution {
    private List<Integer> input = new ArrayList<>();

    public List<Integer> getInput() {
        return input;
    }

    public void setInput(List<Integer> input) {
        this.input = input;
    }

    public void add(int value){
        input.add(value);
    }

    public boolean find(int value){
        int[] data = convertList(input);
        return findTwoSum(data, value);
    }

    private boolean findTwoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i<numbers.length; i++){
            if (hashMap.containsKey(target - numbers[i])){
                return true;
            }
            else{
                hashMap.put(numbers[i], i);
            }
        }
        return false;
    }

    private int[] convertList(List<Integer> input){
        int[] ret = new int[input.size()];
        Iterator<Integer> ite = input.iterator();
        for (int i=0; i<input.size(); i++){
            ret[i] = ite.next();
        }

        return ret;
    }

    public static void main(String[] args){
        List<Integer> input = new ArrayList<>();
        Solution solution = new Solution();
        solution.setInput(input);

        solution.add(1);
        solution.add(3);
        solution.add(5);

        System.out.println(solution.find(4));
    }
}
