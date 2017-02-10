package realworld.morganstanley.linkedlistremoveperf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by jianshen on 2/9/17.
 */
public class LinkedListRemovePerformance {
    public static final int MAX_VAL = 10000;
    public static List<Integer> linkedList = new LinkedList<>();
    public static List<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        for(int i = 0; i < MAX_VAL; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }

        System.out.println("Insert by value -\t");
        long time = System.nanoTime();
        for(int i = 0; i < MAX_VAL; i++) {
            linkedList.add(MAX_VAL/2, i);
        }
        System.out.println("LL time:\t" + (System.nanoTime() - time));

        time = System.nanoTime();
        for(int i = 0; i < MAX_VAL; i++) {
            arrayList.add(MAX_VAL/2, i);
        }
        System.out.println("AL time:\t" + (System.nanoTime() - time));

        resetLists();
        System.out.println("==================");

        System.out.println("Insert by listIterator -\t");
        time = System.nanoTime();
        ListIterator<Integer> li = linkedList.listIterator(MAX_VAL/2);
        for(int i = 0; i < MAX_VAL; i++) {
            li.add(i);
        }
        System.out.println("LL iterator:\t" + (System.nanoTime() - time));

        time = System.nanoTime();
        ListIterator<Integer> ali = arrayList.listIterator(MAX_VAL/2);
        for(int i = 0; i < MAX_VAL; i++) {
            ali.add(i);
        }
        System.out.println("AL iterator:\t" + (System.nanoTime() - time));

        resetLists();
        System.out.println("==================");

        System.out.println("Remove by index -\t");
        time = System.nanoTime();
        for(int i = 0; i < MAX_VAL/2; i++) {
            linkedList.remove(MAX_VAL/2);
        }
        System.out.println("LL time:\t" + (System.nanoTime() - time));

        time = System.nanoTime();
        for(int i = 0; i < MAX_VAL/2; i++) {
            arrayList.remove(MAX_VAL/2);
        }
        System.out.println("AL time:\t" + (System.nanoTime() - time));

        resetLists();
        System.out.println("==================");

        System.out.println("Remove by listIterator -\t");
        time = System.nanoTime();
        li = linkedList.listIterator(MAX_VAL/2);
        while (li.hasNext()) {
            li.next();
            li.remove();
        }
        System.out.println("LL time:\t" + (System.nanoTime() - time));

        time = System.nanoTime();
        ali = arrayList.listIterator(MAX_VAL/2);
        while (ali.hasNext()) {
            ali.next();
            ali.remove();
        }
        System.out.println("AL time:\t" + (System.nanoTime() - time));
    }

    static void resetLists() {
        //Reset the lists
        linkedList = new LinkedList<>();
        arrayList = new ArrayList<>();
        for(int i = 0; i < MAX_VAL; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }
    }
}
