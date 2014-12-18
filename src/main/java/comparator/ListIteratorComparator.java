package comparator;

import java.util.Comparator;
import java.util.ListIterator;

/**
 * Author: blueaken
 * Date: 7/9/14 9:28 下午
 */
// not wokring too, since set() method only replace the previous returned value, not the cursor position. Not seeing it works
// as a Priority Queue's comparator
public class ListIteratorComparator implements Comparator<ListIterator> {
    @Override
    public int compare(ListIterator a, ListIterator b){
        Integer first = (Integer)a.next();
        Integer second = (Integer)b.next();

        //reset cursor to the original position
        a.set(first);
        b.set(second);

        return  first - second;
    }
}
