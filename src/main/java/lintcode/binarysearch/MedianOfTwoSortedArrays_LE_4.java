package lintcode.binarysearch;

public class MedianOfTwoSortedArrays_LE_4 {
    /*
        read Huifeng Guan video and redo
        - https://www.youtube.com/watch?v=5hNWtR2EcrU
        - the goal is to achieve O(Log(M + N)), instead of O(M + N)
        - not a typical BS
        ==============================================
        X0 - K/2 th, Y0 - K/2 th;

        [XXXXX X0] XXXXX
        [YYYYYY Y0] YYYYYYY

        if X0 < Y0, then we can drop the [XXXXX X0] part,
        else we can drop [YYYYYY Y0] part, keep dropping recusivly till edge condition reached

        ==============================================
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return findKthElement(nums1, 0, nums2, 0, len/2+1);
        } else {
            return (findKthElement(nums1, 0, nums2, 0, len/2) + findKthElement(nums1, 0, nums2, 0, len/2+1)) / 2;
        }
    }

    private double findKthElement(int[] nums1, int a, int[] nums2, int b, int k) {
        int m = nums1.length;
        int n = nums2.length;

        //always put less element arr as nums1
        if (m - a > n - b) {
            return findKthElement(nums2, b, nums1, a, k);
        }

        if (m == a) {
            return nums2[b+k-1];
        }

        if (k == 1) {
            return Math.min(nums1[a], nums2[b]);
        }

        int k1 = 0, k2 = 0;
        if ((a + k/2) >= m) {
            k1 = m - a; //if not enough in nums1, then get all the rest
        } else {
            k1 = k / 2;
        }
        k2 = k - k1;

        if (nums1[a + k1 -1] < nums2[b + k2 -1]) {
            return findKthElement(nums1, a + k1, nums2, b, k - k1);
        } else {
            return findKthElement(nums1, a, nums2, b + k2, k - k2);
        }
    }
}
