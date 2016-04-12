package ninechapter_algorithm.chapter2_binarysearch.required.searchbigsortedarray.second;

/**
 * Definition of ArrayReader:
 *
 * class ArrayReader {
 *      // get the number at index, return -1 if not exists.
 *      public int get(int index);
 * }
 */

/**
 * Author: blueaken
 * Date: 4/12/16 11:55 AM
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
//    public int searchBigSortedArray(ArrayReader reader, int target) {
//        // write your code here
//        int end = 0;
//        while (reader.get(end) != -1 && reader.get(end) < target) {
//            end = 2 * end + 1;
//        }
//
//        int start = 0;
//        while (start < end) {
//            int mid = start + (end - start) / 2;
//            if (reader.get(mid) != -1 && reader.get(mid) < target) {
//                start = mid + 1;
//            } else {
//                end = mid;
//            }
//        }
//
//        return reader.get(start) == target ? start : -1;
//    }
}
