package lintcode.prefixsum;

public class FindPivotIndex_LE_724 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] ps = new int[n+1];
        for (int i = 1; i <= n; i++) {
            ps[i] = ps[i-1] + nums[i-1];
        }

        for (int i = 1; i <= n; i++) {
            int left = ps[i] - nums[i-1];
            int right = ps[n] - ps[i];
            if (left == right) {
                return i-1;
            }
        }
        return -1;
    }
}
