package comparator;

import java.util.Comparator;

/**
 * Author: blueaken
 * Date: 7/9/14 9:23 下午
 */
public class IntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b){
        return a - b;
    }
}

