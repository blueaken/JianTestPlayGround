package leetcode.easy.plusone.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 1/29/16 10:03 AM
 */
public class Solution {
    public static List<Integer> plusOne(List<Integer> digits) {
        int length = digits.size();
        if (length==0) return digits;

        boolean isAdded = false;
        for (int i=length-1; i>=0; i--){
            if (digits.get(i)!=9){
                digits.set(i, digits.get(i)+1);
                isAdded = true;
                break;
            } else {
                digits.set(i, 0);
            }
        }

        if(!isAdded){
            //more efficient than digits.add(0,1)
            digits.add(0);
            digits.set(0, 1);
        }

        return digits;
    }

    public static void main(String[] args){
        List<Integer> digits = new ArrayList<>();
        digits.add(1);
        digits.add(2);
        digits.add(3);
//        digits.add(9);

//        digits.add(9);
//        digits.add(9);
//        digits.add(9);

//        digits.add(9);
//        digits.add(8);
//        digits.add(7);
//        digits.add(6);
//        digits.add(5);
//        digits.add(4);
//        digits.add(3);
//        digits.add(2);
//        digits.add(1);


        List<Integer> result = plusOne(digits);
        for (Integer i: result){
            System.out.println(i);
        }

    }

}

