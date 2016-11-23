package ninechapter_algorithm.chapter7_array_and_number.twosum;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 4/28/16 8:28 AM
 */
public class Solution_No_HashMap {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [value1, value2]
     */
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers == null || numbers.length == 0) {
            return result;
        }

        Arrays.sort(numbers);
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int val = numbers[start] + numbers[end];
            if (val == target) {
                result[0] = numbers[start];
                result[1] = numbers[end];
                return result;
            }
            if (val < target) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1,0,-1};
        int target = 0;

        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
}
