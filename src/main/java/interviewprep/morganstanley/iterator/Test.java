package interviewprep.morganstanley.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author jianshen
 */
public class Test {
    public static void main(String[] args){
        ObjectTest objectTest = new ObjectTest();

        //expect print the integer list
        List<Integer> integerList = new ArrayList<Integer>(Arrays.asList(3,6,9));
        Iterator<Integer> integerIterator = integerList.iterator();

        FilteringIterator<Integer> filteringIterator = new FilteringIterator<Integer>(integerIterator, objectTest);
        while (filteringIterator.hasNext()){
            System.out.println(filteringIterator.next());
        }

        //should not output any result
        List<String> stringList = new ArrayList<String>(Arrays.asList("3", "6", "9"));
        Iterator<String> stringIterator = stringList.iterator();

        FilteringIterator<String> filteringStringIterator = new FilteringIterator<String>(stringIterator, objectTest);
        while (filteringStringIterator.hasNext()){
            System.out.println(filteringStringIterator.next());
        }

    }
}
