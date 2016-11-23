package ninechapter_algorithm.chapter2_binarysearch.required.searchbigsortedarray.third;

/**
 * Author: blueaken
 * Date: 6/21/16 12:34
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
//    public int searchBigSortedArray(ArrayReader reader, int target) {
//        // write your code here
//        if (reader == null) {
//            return -1;
//        }
//
//        int end = 1;
//        while (reader.get(end) != -1 && reader.get(end) < target) {
//            end *= 2;
//        }
//
//        int start = 0;
//        while (start < end) {
//            int mid = (start + end) / 2;
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
