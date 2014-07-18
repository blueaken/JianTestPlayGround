package freq5;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Author: blueaken
 * Date: 7/18/14 12:30 上午
 */
public class TwoSum {
    //level2
    //O(N) solution, in addition to straightforward O(N^2) one
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i=0; i<numbers.length; i++){
            if (hm.containsKey(target - numbers[i])){
                result[0] = hm.get(target - numbers[i]) + 1;
                result[1] = i + 1;
            } else{
                hm.put(numbers[i], i);
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[] num = {2, 7, 56, 78};
        int target = 9;

        int[] result = twoSum(num, target);
        System.out.println(Arrays.toString(result));
    }
}
