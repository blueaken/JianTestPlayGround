package lintcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_method2_57 {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> res = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return res;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i != 0 && numbers[i] == numbers[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = numbers.length - 1;
            int target = -numbers[i];
            twoSum(numbers, j, k, target, res);
        }
        return res;
    }

    private void twoSum (int[] numbers, int j, int k, int target, List<List<Integer>> res) {
        while (j < k) {
            int sum = numbers[j] + numbers[k];
            if ( sum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(target * -1);
                list.add(numbers[j]);
                list.add(numbers[k]);
                res.add(list);

                j++;
                while (j < k && numbers[j] == numbers[j-1]) {
                    j++;
                }

                k--;
                while (j < k && numbers[k] == numbers[k+1]) {
                    k--;
                }
            } else if (sum < target) {
                j++;
            } else {
                k--;
            }
        }

    }

    public static void main(String[] args) {
//        int[] input = {2,7,11,15};
        int[] input = {1,0,-1,-1,-1,-1,0,1,1,1};

        ThreeSum_method2_57 solution = new ThreeSum_method2_57();
        System.out.println(solution.threeSum(input).toString());
    }

}
