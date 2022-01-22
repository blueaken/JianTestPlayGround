package lintcode.twopointers;

import java.util.Arrays;

public class ClosestTargetValue_1478 {
    /**
     * @param target: the target
     * @param array: an array
     * @return: the closest value
     */
    public int closestTargetValue(int target, int[] array) {
        // Write your code here
        if (array.length == 0) {
            return -1;
        }

        Arrays.sort(array);
        int minDiff = Integer.MAX_VALUE;
        int left = 0, right = array.length - 1;
        boolean found = false;
        while (left < right) {
            int sum = array[left] + array[right];
            int diff = target - sum;
            if (diff < 0) {
                right--;
                continue;
            }

            //only count minDiff on target >= sum cases
            found = true;
            minDiff = Math.min(minDiff, diff);
            if (diff == 0) {
                return sum;
            } else if (diff > 0) {
                left++;
            }
        }
        return found ? target - minDiff : -1;
    }

    public static void main(String[] args) {
//        int[] input = {-12,-5,14,5,0,-16};
//        int target = -10;

        int[] input = {1,2,3,4,5,6,7,8,9,0};
        int target = -100;

        ClosestTargetValue_1478 solution = new ClosestTargetValue_1478();
        System.out.println(solution.closestTargetValue(target,input));
        System.out.println(Arrays.toString(input));
    }
}
