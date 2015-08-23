package leetcode.easy.plusone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jshe18 on 8/23/15.
 */
public class Solution_Digits {

    public static int[] plusOne(int[] digits) {
        int length = digits.length;

        if (length==0) return digits;

        //easier to handle it in list rather than array (fixed length)
        Integer[] temp = new Integer[length];
        for (int i=0; i<length; i++){
            temp[i] = digits[i];
        }
        //note: have to create a new list since Arrays.asList returns a fixed size list by definition
        List<Integer> inputList = new ArrayList<>(Arrays.asList(temp));

        boolean isAdded = false;
        for (int i= length-1; i>=0; i--){
            if (inputList.get(i)<9){
                inputList.set(i, inputList.get(i)+1);
                isAdded = true;
                break;
            }else {
                inputList.set(i, 0);
            }
        }
        if (!isAdded) {
//            inputList.add(0,1);
            //note: slightly strange here comparing to directly insert 1 to the front of list?. The consideration is the list is
            // implemented as an ArrayList, appending an element is far more efficient than inserting to the front, because all elements
            // have to be shifted one place to the right otherwise.
            inputList.add(0);
            inputList.set(0,1);
        }

        //convert it back to array
        int[] result = new int[inputList.size()];
        for (int i=0; i<inputList.size(); i++){
            result[i] = inputList.get(i);
        }

        return result;
    }

    public static void main(String[] args){
//        int[] digits = {1,2,3};
        int[] digits = {9,9,9};
//        int[] digits = {9,8,7,6,5,4,3,2,1,0};

        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
