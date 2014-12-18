package freq5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 7/20/14 11:00 下午
 */
public class ThreeSum_BinarySearchSolution {
    //binary search solution, nlogn
    public static List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(num);

        for (int i = 0; i < num.length - 1; i++) {       //front index moving forward
            for (int j = num.length - 1; j > i; j--) {   //back index moving backward
                int remain = 0 - (num[i] + num[j]);
                int third = Arrays.binarySearch(num, i + 1, j, remain);
                if (third >= 0) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[third]);
                    list.add(num[j]);
                    ret.add(list);
                }
            }
        }

        return ret;
    }
}
