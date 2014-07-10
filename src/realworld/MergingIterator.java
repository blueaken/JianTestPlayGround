package realworld;

import javax.naming.OperationNotSupportedException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author jianshen
 */
public class MergingIterator implements Iterator<Integer> {

    private List<Integer> sortedStreams;

    public MergingIterator(List<Integer> sortedStreams) { }

    @Override
    public Integer next(){
        if (!hasNext()) throw new NoSuchElementException();
        return sortedStreams.get(0);
    }

    @Override
    public boolean hasNext(){
        return sortedStreams.isEmpty();
    }

    @Override
    public void remove() {
        //throw new OperationNotSupportedException();
    }
}
