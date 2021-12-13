package lintcode.colleciton.selected.phase3_and_phase4_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestWords_133 {
    /*
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    //Key Idea: 这些一次遍历搞定的，套路无非都是在遍历的时候就记录数据的状态，然后根据遍历到的当前的数据的状态来修改最终结果，当遍历完了的时候结果也就确定了
    public List<String> longestWords(String[] dictionary) {
        // write your code here
        Map<Integer, Integer> temp = new HashMap<>();
        int max = 0;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i].length() > max) {
                max = dictionary[i].length();
                result = new ArrayList<>();
                result.add(dictionary[i]);
            } else if (dictionary[i].length() == max) {
                result.add(dictionary[i]);
            }
        }

        return result;
    }
}
