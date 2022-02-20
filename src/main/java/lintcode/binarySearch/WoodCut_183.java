package lintcode.binarySearch;

public class WoodCut_183 {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    //Idea: 1. 类似437书籍复印思路
    //      2. 标准模板对长度重复情况有问题，还是使用九章模板
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }

        int start = 1;
        int end = 0;
        for (int i = 0; i < L.length; i++) {
            end = Math.max(end, L[i]);
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isWorkable(L, mid, k)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (isWorkable(L, end, k)) {
            return end;
        }
        return start;
    }

    private boolean isWorkable (int[] L, int len, int k) {
        int count = 0;
        for (int i = 0; i < L.length; i++) {
            count += L[i] / len;
        }
        return count >= k;
    }

    public static void main(String[] args) {
//        int[] input = {232, 124, 456};
//        int k = 7;

        int[] input = {123, 123, 123};
        int k = 3;

        WoodCut_183 solution = new WoodCut_183();
        System.out.println(solution.woodCut(input, k));
    }
}
