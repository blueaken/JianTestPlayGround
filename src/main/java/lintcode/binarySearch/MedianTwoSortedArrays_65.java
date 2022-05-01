package lintcode.binarySearch;

public class MedianTwoSortedArrays_65 {
    /**
     * @param a: An integer array
     * @param b: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] a, int[] b) {
        // write your code here
        int lenA = a.length;
        int lenB = b.length;
        if (lenA == 0) {
            return getMedian(b);
        }
        if (lenB == 0) {
            return getMedian(a);
        }

        int [] c = new int[lenA + lenB];
        int i = 0, j = 0, k = 0;
        while (i < lenA && j < lenB) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        while (i < lenA) {
            c[k++] = a[i++];
        }
        while (j < lenB) {
            c[k++] = b[j++];
        }

        return getMedian(c);
    }

    private double getMedian (int[] nums) {
        int len = nums.length;
        if (len % 2 == 1) {
            return nums[len/2];
        } else {
            return (double)(nums[len/2 - 1] + nums[len/2]) / 2;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        int[] b = {2,3,4,5};
        //3.5

        MedianTwoSortedArrays_65 solution = new MedianTwoSortedArrays_65();
        System.out.println(solution.findMedianSortedArrays(a, b));
    }
}
