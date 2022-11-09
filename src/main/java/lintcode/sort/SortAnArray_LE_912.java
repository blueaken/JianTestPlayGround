package lintcode.sort;

public class SortAnArray_LE_912 {
    /*
        11.09.2022
        solve with merge sort
    */
    int[] temp;
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        temp = new int[n];
        sort(nums, 0, n-1);

        return nums;
    }

    private void sort(int[] nums, int lo, int hi) {
        //base case - if only one element left, no need to sort
        if (lo == hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;

        sort(nums, lo, mid);
        sort(nums, mid+1, hi);

        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        // 先把 nums[lo..hi] 复制到辅助数组中,以便合并后的结果能够直接存入 nums
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }

        int i = lo, j = mid+1;
        int pos = lo;
        while (i <= mid && j <= hi) {
            if (temp[i] < temp[j]) {
                nums[pos++] = temp[i++];
            } else {
                nums[pos++] = temp[j++];
            }
        }
        while (i <= mid) {
            nums[pos++] = temp[i++];
        }
        while (j <= hi) {
            nums[pos++] = temp[j++];
        }
    }
}
