package lintcode.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindNearestStore_1629 {
    /**
     * @param stores: The location of each store.
     * @param houses: The location of each house.
     * @return: The location of the nearest store to each house.
     */
    //Idea: 对商店进行排序后，用九章模板二分查找商店的位置即可
    public List<Integer> findNearestStore(List<Integer> stores, List<Integer> houses) {
        List<Integer> locations = new ArrayList<>();
        if (houses == null || houses.size() == 0) {
            return locations;
        }

        Collections.sort(stores);
        for (Integer house : houses) {
            int nearestStore = find(stores, house);
            locations.add(nearestStore);
        }
        return locations;
    }

    private int find(List<Integer> stores, Integer house) {
        int start = 0, end = stores.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int curStore = stores.get(mid);
            if (curStore == house) {
                return curStore;
            }
            if (curStore < house) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (Math.abs(stores.get(start) - house) > Math.abs(stores.get(end) - house)) {
            return stores.get(end);
        } else {
            return stores.get(start);
        }

    }

    public static void main(String[] args) {
        List<Integer> stores = Arrays.asList(1, 3, 6);
        List<Integer> houses = Arrays.asList(2, 4, 6, 7);

        FindNearestStore_1629 solution = new FindNearestStore_1629();
        System.out.println(solution.findNearestStore(stores, houses));
    }
}
