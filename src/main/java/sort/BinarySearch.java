package sort;

import java.util.Arrays;

/**
 * Created by jianshen on 12/25/14.
 */
public class BinarySearch {
    public static void main(String[] args){
        int[] testArr = {3,45,57,23,15,39,78,22,23};
        Arrays.sort(testArr);
        b_search(testArr, 39);
    }

    private static void b_search(int[] input, int target){
        int size = input.length;
        if (size == 0) {
            System.out.println("Target not found.");
            return;
        }

        if (size == 1 && target != input[0]) {
            System.out.println("Target not found.");
            return;
        }

        int midIndex = size/2;
        int midValue = input[midIndex];
        if (target < midValue){
            int[] tempArray = Arrays.copyOfRange(input, 0, midIndex);
            b_search(tempArray, target);
        } else if (target > midValue){
            int[] tempArray = Arrays.copyOfRange(input, midIndex, size);
            b_search(tempArray, target);
        } else if (target == input[midIndex]){
            System.out.println("Target found.");
            return;
        }

    }
}
