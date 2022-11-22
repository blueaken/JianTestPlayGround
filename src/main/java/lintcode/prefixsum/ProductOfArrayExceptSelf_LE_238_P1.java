package lintcode.prefixsum;

public class ProductOfArrayExceptSelf_LE_238_P1 {
    /**
     11.22.2022
     ref 东哥 post
     - the idea is similar to prefix sum
     - build a prefix product array and a suffix product array, to avoid the divide operation handling
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix_prod = new int[n];
        prefix_prod[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix_prod[i] = prefix_prod[i-1] * nums[i];
        }

        int[] postfix_prod = new int[n];
        postfix_prod[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            postfix_prod[i] = postfix_prod[i+1] * nums[i];
        }

        int[] res = new int[n];
        res[0] = postfix_prod[1];
        res[n-1] = prefix_prod[n-2];
        for (int i = 1; i < n-1; i++) {
            // 除了 nums[i] 自己的元素积就是 nums[i] 左侧和右侧所有元素之积
            res[i] = prefix_prod[i-1] * postfix_prod[i+1];
        }
        return res;
    }
}
