package lintcode.twopointers;

public class MinSwaps_LE_1151 {
    /*
        - 1. find the number of 1's, say n
        - 2. for each subarray of size n, found the number of swaps needs and find the min
    */
    public int minSwaps(int[] data) {
        int num = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 1) {
                num++;
            }
        }

        if (num == 1) {
            return 0;
        }

        int left = 0, right = num - 1, min = Integer.MAX_VALUE;
        while (left < right && right < data.length) {
            int count = getZeros(data, left++, right++);
            min = Math.min(min, count);
        }
        return min;
    }

    private int getZeros(int[] data, int left, int right) {
        int count = 0;
        while (left <= right) {
            if (data[left++] == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinSwaps_LE_1151 solution = new MinSwaps_LE_1151();
//        int[] data = {1,0,1,0,1}; // 1
//        int[] data = {0,0,0,1,0}; // 0
        int[] data = {1,0,1,0,1,0,0,1,1,0,1}; //2

        System.out.println(solution.minSwaps(data));
    }
}
