package ninechapter_algorithm.chapter8_data_structure.optional.implementqueuebylinkedlist2;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 6/6/16 09:20
 */
public class Dequeue {
    private static List<Integer> list;

    public Dequeue() {
        // do initialize if necessary
        this.list = new LinkedList<>();
    }

    public void push_front(int item) {
        // Write your code here
        list.add(0, item);
    }

    public void push_back(int item) {
        // Write your code here
        list.add(item);
    }

    public int pop_front() {
        // Write your code here
        return list.remove(0);
    }

    public int pop_back() {
        // Write your code here
        return list.remove(list.size() - 1);
    }
}

