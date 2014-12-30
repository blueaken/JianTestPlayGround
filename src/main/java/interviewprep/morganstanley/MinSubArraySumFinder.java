package interviewprep.morganstanley;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jianshen on 12/28/14.
 */
public class MinSubArraySumFinder {
    public static void main(String[] args){
        int[] input = {4, 4, 3, 3, 2};
        findMinSubArraySum(input);
    }

    private static void findMinSubArraySum(int[] data){
        if (data.length == 0) {
            System.out.println("Input array is empty.");
            return;
        }

        if (data.length == 1) {
            System.out.println("Input array is size one: " + data[0]);
            return;
        }

        Arrays.sort(data);

        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr1.add(data[0]);
        arr2.add(data[1]);
        int sum1 = data[0];
        int sum2 = data[1];

        for (int i= 2; i<data.length; i++){
            if (sum1 > sum2){
                arr2.add(data[i]);
                sum2 += data[i];
            } else{
                arr1.add(data[i]);
                sum1 += data[i];
            }
        }

        System.out.println("The 1st sub array is: ");
        for(Integer i: arr1){
            System.out.print(i + " ");
        }

        System.out.println("");

        System.out.println("The 2nd sub array is: ");
        for(Integer i: arr2){
            System.out.print(i + " ");
        }

        System.out.println("");
        System.out.println("");

        System.out.println("The diff of the 2 sum is: " + Math.abs(sum1-sum2));
    }
}
