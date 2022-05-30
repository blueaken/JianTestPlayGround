package lintcode.math;

public class FindMissingNumber_196 {
    /**
     * @param nums: An array of integers
     * @return: An integer
     */
    //Idea: 在O(N)时间内解决，就不能先排序。考虑使用异或，因为相同的数异或结果为零的性质
    public int findMissing(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        for (int i = 0; i <= nums.length; i++) {
            res ^= i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {9,8,7,6,2,0,1,5,4};

        FindMissingNumber_196 solution = new FindMissingNumber_196();
        System.out.println(solution.findMissing(input));
    }
}
