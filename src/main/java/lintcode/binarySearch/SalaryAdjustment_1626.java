package lintcode.binarySearch;

import java.util.Arrays;

public class SalaryAdjustment_1626 {
    /**
     * @param a: the list of salary
     * @param target: the target of the sum
     * @return: the cap it should be
     */
    //Idea；先排序，cap的范围应该在首元素到(target/个数)+1之间，通过二分找到最小值
    public int getCap(int[] a, int target) {
        // Write your code here.
        if (a == null || a.length == 0) {
            return -1;
        }
        Arrays.sort(a);

        int start = a[0], end = target / a.length + 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isWorkable(a, mid, target)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean isWorkable (int[] a, int cap, int target) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < cap) {
                sum += cap;
            } else {
                sum += a[i];
            }
        }
        return sum >= target;
    }

    public static void main(String[] args) {
//        int[] a = {1,2,3,4,5,6,7,8};
//        int target = 42;

        int[] a = {1,2,3,4,5,6};
        int target = 100;

        SalaryAdjustment_1626 solution = new SalaryAdjustment_1626();
        System.out.println(solution.getCap(a, target));
    }
}
