package lintcode.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class SearchRange_1536 {
    /**
     * @param nums: the array of integers
     * @param target:
     * @return: the starting and ending position
     */
    //Idea: attack with nine chapter template, ref - https://www.lintcode.com/problem/61/solution/32944
    public List<Integer> searchRange(List<Integer> nums, int target) {
        // Write your code here.
        int leftBound = -1;
        int rightBound = -1;
        List<Integer> NF = new ArrayList<>();
        NF.add(leftBound);
        NF.add(rightBound);
        if (nums == null || nums.size() == 0) {
            return NF;
        }

        List<Integer> res = new ArrayList<>();
        int start = 0, end = nums.size() - 1;
        //leftBound
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (nums.get(start) == target) {
            leftBound = start;
        } else if (nums.get(end) == target){
            leftBound = end;
        }

        //rightBound
        start = 0;
        end = nums.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums.get(mid) <= target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        if (nums.get(end) == target) {
            rightBound = end;
        } else if (nums.get(start) == target) {
            rightBound = start;
        }

        res.add(leftBound);
        res.add(rightBound);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(5);
        input.add(7);
        input.add(7);
        input.add(8);
        input.add(8);
        input.add(10);
//        int target = 8;
        int target = 6;

        SearchRange_1536 solution = new SearchRange_1536();
        System.out.println(solution.searchRange(input, target));
    }
}
