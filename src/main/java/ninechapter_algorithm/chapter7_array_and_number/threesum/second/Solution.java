package ninechapter_algorithm.chapter7_array_and_number.threesum.second;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 5/24/16 10:42
 */
public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public static ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length < 3) {
            return result;
        }

        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            //remove duplicates on i
            if ( i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = numbers.length - 1;
            while (start < end) {
                ArrayList<Integer> list = new ArrayList<>();
                int sum = numbers[i] + numbers[start] + numbers[end];
                if (sum == 0) {
                    list.add(numbers[i]);
                    list.add(numbers[start]);
                    list.add(numbers[end]);
                    result.add(list);
                    start++;
                    //remove duplicates on start
                    while (start < end && numbers[start] == numbers[start - 1]) {
                        start++;
                    }
                    end--;
                    //remove duplicates on end
                    while (start < end && numbers[end] == numbers[end + 1]) {
                        end--;
                    }
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        //int[] test = {-1,0,1,2,-1,-4};

        int[] test = {1,0,-1,-1,-1,-1,0,1,1,1};

        System.out.println(threeSum(test));
    }
}
