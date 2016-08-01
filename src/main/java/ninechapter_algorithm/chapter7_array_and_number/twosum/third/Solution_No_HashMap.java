package ninechapter_algorithm.chapter7_array_and_number.twosum.third;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 8/1/16 09:16
 */
public class Solution_No_HashMap {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] result = new int[2];
        if (numbers == null || numbers.length == 0) {
            return result;
        }

        Arrays.sort(numbers);
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (target == sum) {
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            }
            if (target < sum) {
                end--;
            } else {
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution_No_HashMap solution_no_hashMap = new Solution_No_HashMap();
        int[] test = {2, 7, 11, 15};
        System.out.println(Arrays.toString(solution_no_hashMap.twoSum(test, 9)));
    }
}
