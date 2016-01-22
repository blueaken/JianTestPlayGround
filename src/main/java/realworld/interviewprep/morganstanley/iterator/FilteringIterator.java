package realworld.interviewprep.morganstanley.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author jianshen
 */
public class FilteringIterator<E> implements Iterator<E> {

    private Iterator<E> iterator;
    private IObjectTest objectTest;

    private E nextElement;
    private boolean hasNext;

    public FilteringIterator(Iterator<E> iterator, IObjectTest objectTest){
        this.iterator = iterator;
        this.objectTest = objectTest;

        //nextMatch() set the initial nextElement / hasNext value;
        nextMatch();
    }

    @Override
    public E next(){
        if (!hasNext) {
            throw new NoSuchElementException();
        }

        return nextMatch();
    }

    @Override
    public boolean hasNext(){
        return hasNext;
    }

    @Override
    public void remove(){
        iterator.remove();
    }

    private E nextMatch() {
        E oldMatch = nextElement;

        while (iterator.hasNext()) {
            E o = iterator.next();

            if (objectTest.test(o)) {
                hasNext = true;
                nextElement = o;

                return oldMatch;
            }
        }

        hasNext = false;

        return oldMatch;
    }
}
