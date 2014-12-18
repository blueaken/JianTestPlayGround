package comparator;

import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Author: blueaken
 * Date: 7/9/14 9:48 下午
 */
// Iterator comparator is not going to work since iterator cursor moves after calling next() method, need a method to reset it
// try ListIterator instead
public class IteratorComparator implements Comparator<Iterator> {
    @Override
    public int compare(Iterator a, Iterator b){
        Integer first = (Integer)a.next();
        Integer second = (Integer)b.next();

        return first - second;
    }
}
