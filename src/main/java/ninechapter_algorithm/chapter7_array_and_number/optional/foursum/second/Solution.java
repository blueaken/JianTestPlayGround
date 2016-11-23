package ninechapter_algorithm.chapter7_array_and_number.optional.foursum.second;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 5/24/16 12:07
 */
public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        /* your code */
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length < 4) {
            return result;
        }

        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 3; i++) {
            //remove duplicates on i
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < numbers.length - 2; j++) {
                //remove duplicates on j
                if (j != i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                int start = j + 1;
                int end = numbers.length - 1;
                while (start < end) {
                    ArrayList<Integer> list = new ArrayList<>();
                    int sum = numbers[i] + numbers[j] + numbers[start] + numbers[end];
                    if (sum == target) {
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[start]);
                        list.add(numbers[end]);
                        result.add(list);
                        start++;
                        end--;
                        //remove duplicates on start and end
                        while (start < end && numbers[start] == numbers[start - 1]) {
                            start++;
                        }
                        while (start < end && numbers[end] == numbers[end + 1]) {
                            end--;
                        }
                    } else if (sum < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return result;
    }
}
