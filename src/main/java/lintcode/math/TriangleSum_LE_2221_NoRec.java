package lintcode.math;

public class TriangleSum_LE_2221_NoRec {
    /*
        - Need array copy method:
        - the strongest is System.arraycopy(Object src, int srcPos, Object dest,
                             int destPos, int length) Method, has every parameter specified
        - the easier to use is Arrays.copyOfRange(int[] original, int from, int to), from - inclusive, to - exclusive
        ===================================
        - ref solution link to solve it without recursive
    */

    public int triangularSum(int[] nums) {

        int index = nums.length - 1;
        while (index > 0) {
            for (int i = 0; i < index; i++) {
                nums[i] = (nums[i] + nums[i+1]) % 10;
            }
            index--;
        }

        return nums[0];
    }

}
