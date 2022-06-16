package lintcode.sort;

import java.util.TreeMap;

public class RelativeSortArray_LE_1122 {
    /*
        - ref https://leetcode.com/problems/relative-sort-array/discuss/335056/Java-in-place-solution-using-counting-sort
        - using TreeMap, Time: O(NLogN), Space: O(N)
        - since the array length <= 1000, can also use contant size array of size 1001 count[1001] to replace TreeMap, Time and Space would be O(1)
    */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>(); //value, count
        for (int i : arr1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int i = 0;
        for (int n : arr2) {
            for (int j = 0; j < map.get(n); j++) {
                arr1[i++] = n;
            }
            map.remove(n);
        }
        for (int n : map.keySet()) {
            for (int j = 0; j < map.get(n); j++) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }
}
