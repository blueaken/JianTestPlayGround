package lintcode.colleciton.selected.phase3_array;

public class SecondMax_479 {
    /**
     * @param nums: An integer array
     * @return: The second max number in the array.
     */
    public static int secondMax(int[] nums) {
        // write your code here
        int fir = nums[0] >= nums[1] ? nums[0] : nums[1];
        int sec = nums[0] >= nums[1] ? nums[1] : nums[0];

        for (int i = 2; i < nums.length; i++) {
            if (fir >= nums[i]) {
                sec = sec >= nums[i] ? sec : nums[i];
            } else {
                sec = fir;
                fir = nums[i];
            }
        }
        return sec;
    }

    public static void main(String[] args) {
        int[] input = {1,3,2,4};
        System.out.println(secondMax(input));
    }
}
