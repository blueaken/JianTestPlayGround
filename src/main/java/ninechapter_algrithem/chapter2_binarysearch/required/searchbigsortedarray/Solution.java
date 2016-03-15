package ninechapter_algrithem.chapter2_binarysearch.required.searchbigsortedarray;

/**
 * Author: blueaken
 * Date: 2/23/16 2:49 PM
 */

/**
 * Definition of ArrayReader:
 *
 * class ArrayReader {
 *      // get the number at index, return -1 if not exists.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader can read number by index.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
//    public int searchBigSortedArray(ArrayReader reader, int target) {
//        // Algorithm:
//        // 1. get the index that ArrayReader.get(index) >= target or == -1 in
//        //    O(logk)
//        // 2. Binary search the target between 0 and index
//
//        int index = 1; // initialize the index;
//        while (reader.get(index-1) != -1 && reader.get(index-1) < target /* write your code here */) {
//            // multiply index by 2, so that we can get it in O(logk)
//            index = index * 2;
//        }
//
//        int start = 0, end = index - 1;
//        while (start < end/* write your code here */) {
//            // do binary search
//            int mid = (start + end) / 2;
//            if (reader.get(mid) != -1 && reader.get(mid) < target){
//                start = mid + 1;
//            }else {
//                end = mid;
//            }
//        }
//
//        // return something here
//        if (reader.get(start) == target){
//            return start;
//        }
//
//        return -1;
//    }
}
