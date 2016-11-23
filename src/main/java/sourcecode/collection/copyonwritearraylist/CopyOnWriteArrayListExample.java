package sourcecode.collection.copyonwritearraylist;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Author: blueaken
 * Date: 1/7/16 6:19 AM
 */
public class CopyOnWriteArrayListExample {
    public static void main(String args[]) {

        CopyOnWriteArrayList<String> threadSafeList = new CopyOnWriteArrayList<String>();
        threadSafeList.add("Java");
        threadSafeList.add("J2EE");
        threadSafeList.add("Collection");

        //add, remove operator is not supported by CopyOnWriteArrayList iterator
        Iterator<String> failSafeIterator = threadSafeList.iterator();
        while(failSafeIterator.hasNext()){
            System.out.printf("Read from CopyOnWriteArrayList : %s %n", failSafeIterator.next());
            //failSafeIterator.remove(); //not supported in CopyOnWriteArrayList in Java
        }
    }

    //Read more: http://java67.blogspot.com/2012/09/what-is-copyonwritearraylist-in-java-example-vs-arraylist.html#ixzz3wVOvJdMC
}
