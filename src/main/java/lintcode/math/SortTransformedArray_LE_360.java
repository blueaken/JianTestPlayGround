package lintcode.math;

import java.util.Arrays;

public class SortTransformedArray_LE_360 {
    /**
     03.30.2023
     - similar to LE 977, 需要考虑抛物线函数的开口方向
     */
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int i = 0, j = n - 1;

        int[] res = new int[n];

        // 如果开口朝上，越靠近对称轴函数值越小，可以先确定大的，从后面开始
        // 如果开口朝下，越靠近对称轴函数值越大，可以先确定小弟，从前面开始
        int p = a > 0 ? n - 1 : 0;
        while (i <= j) {
            int v1 = f(nums[i], a, b, c), v2 = f(nums[j], a, b, c);
            if (a > 0) {
                // 如果开口朝上，越靠近对称轴函数值越小，可以先确定大的，从后面开始
                if (v1 > v2) {
                    res[p] = v1;
                    i++;
                } else {
                    res[p] = v2;
                    j--;
                }
                p--;
            } else {
                // 如果开口朝下，越靠近对称轴函数值越大，可以先确定小弟，从前面开始
                if (v1 > v2) {
                    res[p] = v2;
                    j--;
                } else {
                    res[p] = v1;
                    i++;
                }
                p++;
            }

        }
        return res;
    }

    private int f(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }

    public static void main(String[] args) {
        SortTransformedArray_LE_360 solution = new SortTransformedArray_LE_360();
        int[] nums = {-4,-2,2,4};
        int a = -1, b = 3, c = 5;

        System.out.println(Arrays.toString(solution.sortTransformedArray(nums, a, b, c)));
    }
}
