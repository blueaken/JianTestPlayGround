package realworld;

import comparator.ListIteratorComparator;

import java.util.*;
import java.util.List;

/**
 * @author jianshen
 */
public class MergingIterator implements Iterator<Integer> {

    private List<Iterator> sortedStreams;

    private Iterator resultIterator;

    public MergingIterator(List<Iterator> sortedStreams) {
        this.sortedStreams = sortedStreams;

        this.resultIterator = mergeIterator(sortedStreams);
    }

    private ListIterator<Integer> mergeIterator(List<Iterator> sortedStreams){
        Comparator<ListIterator> listIteratorComparator = new ListIteratorComparator();
        PriorityQueue<ListIterator> priorityQueue = new PriorityQueue<ListIterator>(sortedStreams.size(), listIteratorComparator);

        for (Iterator iterator : sortedStreams){
            if (iterator != null){
                priorityQueue.add((ListIterator)iterator);
            }
        }

        List<Integer> resultList = new ArrayList<Integer>();
        while (priorityQueue.size() != 0) {
            Iterator current = priorityQueue.poll();
            resultList.add((Integer)current.next());
        }


        return null;
    }

    @Override
    public Integer next(){
        if (!hasNext()) throw new NoSuchElementException();
        return (Integer)resultIterator.next();
    }

    @Override
    public boolean hasNext(){
        return resultIterator.hasNext();
    }

    @Override
    public void remove() {
        //throw new OperationNotSupportedException();
    }

    public static void main(String[] args){
        Integer[] arr1 = {1, 4, 7};
        Integer[] arr2 = {2, 5, 8};
        Integer[] arr3 = {3, 6, 9};

        List<Integer> arrList1 = new ArrayList<Integer>(Arrays.asList(arr1));
        List<Integer> arrList2 = new ArrayList<Integer>(Arrays.asList(arr2));
        List<Integer> arrList3 = new ArrayList<Integer>(Arrays.asList(arr3));

        ListIterator iterator1 = arrList1.listIterator();
        ListIterator iterator2 = arrList2.listIterator();
        ListIterator iterator3 = arrList3.listIterator();

        List<Iterator> sortedStreams = new ArrayList<Iterator>();
        sortedStreams.add(iterator1);
        sortedStreams.add(iterator2);
        sortedStreams.add(iterator3);

        MergingIterator mergingIterator = new MergingIterator(sortedStreams);
        System.out.println("ttt");
    }
}
