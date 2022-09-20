package lintcode.divideconquer;

public class CreateSortedArrayThroughInstructions_LE_1649 {
    /*
        - ref https://www.youtube.com/watch?v=B7vkfZcJNeY
        - divide & conqure then merge sort
        - similar to 315
        - difficult - Hard+
    */
    int[] sorted = new int[100001];
    int[] smaller = new int[100001];
    int[] temp = new int[100001];
    int[] count = new int[100001];
    long mod = (long)1e9 + 7;

    public int createSortedArray(int[] instructions) {
        int len = instructions.length;
        for (int i = 0; i < len; i++) {
            sorted[i] = instructions[i];
        }

        helper(instructions, 0, len - 1);

        long ret = 0l;
        for (int i = 0; i < len; i++) {
            //greater value: i - count[instructions[i]] - smaller[i]
            int cost = Math.min(smaller[i], i - count[instructions[i]] - smaller[i]);
            ret = (ret + cost) % mod;
            count[instructions[i]]++;
        }
        return (int)ret;
    }

    private void helper(int[] instructions, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        helper(instructions, start, mid);
        helper(instructions, mid+1, end);

        //adjust for the right half
        for (int i = mid + 1; i <= end; i++) {
            int lowerBound = binarySearch(start, mid, instructions[i]);
//            int lowerBound = linearSearch(start, mid, instructions[i]);
            smaller[i] += lowerBound - start;
        }

        //merge sort the 2 sorted array, for O(NLogN) performance
        int i = start, j = mid + 1, pos = 0;
        while (i <= mid && j <= end) {
            if (sorted[i] < sorted[j]) {
                temp[pos] = sorted[i];
                i++;
            } else {
                temp[pos] = sorted[j];
                j++;
            }
            pos++;
        }
        //continue process the remainings
        while (i <= mid) {
            temp[pos] = sorted[i];
            pos++;
            i++;
        }
        while (j <= end) {
            temp[pos] = sorted[j];
            pos++;
            j++;
        }
        //copy the result back to sorted array
        for (int k = 0; k < pos; k++) {
            sorted[start + k] = temp[k];
        }
    }

    private int linearSearch(int start, int end, int target) {
        int lowerBound = start;
        while (lowerBound <= end) {
            if (target > sorted[lowerBound])
                lowerBound++;
            else
                return lowerBound;
        }

        return lowerBound;
    }

    private int binarySearch(int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (sorted[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        // If target is still greater than last element which is sorted[start] then lower bound does not exists in the array
        if (sorted[start] < target) {
            start++;
        }

        return start;
    }

    public static void main(String[] args) {
        CreateSortedArrayThroughInstructions_LE_1649 solution = new CreateSortedArrayThroughInstructions_LE_1649();
//        int[] instructions = {1,5,6,2};//1
        int[] instructions = {1,2,1,2,1,2};//0
        System.out.println(solution.createSortedArray(instructions));

    }
}
