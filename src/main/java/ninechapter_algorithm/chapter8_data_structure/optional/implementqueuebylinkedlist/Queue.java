package ninechapter_algorithm.chapter8_data_structure.optional.implementqueuebylinkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 6/6/16 09:12
 */
public class Queue {
    private static List<Integer> list;

    public Queue() {
        // do initialize if necessary
        this.list = new ArrayList<>();
    }

    public void enqueue(int item) {
        // Write your code here
        list.add(item);
    }

    public int dequeue() {
        // Write your code here
        return list.remove(0);
    }
}
