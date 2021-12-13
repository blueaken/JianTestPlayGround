package lintcode.colleciton.selected.phase3_and_phase4_array;

import java.util.ArrayList;
import java.util.List;

public class ProductExcludeItself_50 {

    /*
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    //左右分治，时间复杂度 O(n), 但需要额外2个数组空间。
    public List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        List<Long> B = new ArrayList<>();

        if (nums.size() == 0) {
            long b = 1;
            B.add(b);
            return B;
        }

        long[] left = new long[nums.size()];
        left[0] = 1;
        for (int i = 1; i < nums.size(); i++) {
            left[i] = left[i-1] * nums.get(i-1);
        }

        long[] right = new long[nums.size()];
        right[nums.size()-1] = 1;
        for (int i = nums.size() - 2; i >= 0; i--) {
            right[i] = right[i+1] * nums.get(i+1);
        }

        for (int i = 0; i < nums.size(); i++) {
            B.add(left[i] * right[i]);
        }
        return B;
    }

}
