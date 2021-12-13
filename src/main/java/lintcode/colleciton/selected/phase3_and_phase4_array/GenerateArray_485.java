package lintcode.colleciton.selected.phase3_and_phase4_array;

import java.util.ArrayList;
import java.util.List;

public class GenerateArray_485 {
    /**
     * @param size: An integer
     * @return: An integer list
     */
    public List<Integer> generate(int size) {
        // write your code here
        List<Integer> ret = new ArrayList<>() ;
        for (int i = 0; i < size; i++) {
            ret.add(i + 1);
        }
        return ret;
    }
}
