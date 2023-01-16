package lintcode.math.bitmanipulation;

public class MissingNumber_LE_268 {
    /**
     1.16.2023
     - ref东哥post, 有多种解法，首先可以用等差数量求和公式，找出the missing number; O(N)
     - 如果用bit operator的话，利用任何数和自身异或为0的性质
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        res ^= n; // 先和新补的索引异或
        for (int i = 0; i < n; i++) {
            res ^= i ^ nums[i];
        }

        return res;
    }
}
