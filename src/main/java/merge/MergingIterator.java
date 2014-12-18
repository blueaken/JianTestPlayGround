package merge;

import type.ListNode;

import java.util.*;

class IteratorComparator implements Comparator<Iterator<Integer>> {
    @Override
    public int compare(Iterator<Integer> a, Iterator<Integer> b){
        int na = a.next();
        int nb = b.next();
        return na - nb;
    }
}
/**
 * @author jianshen
 */
public class MergingIterator {
    private List<Iterator> sortedStreams;
    private List<Integer> result;

    public List<Iterator> getSortedStreams() {
        return sortedStreams;
    }

    public void setSortedStreams(List<Iterator> sortedStreams) {
        this.sortedStreams = sortedStreams;
    }

    public List<Integer> getResult() {
        return result;
    }

    public void setResult(List<Integer> result) {
        this.result = result;
    }

    public MergingIterator(List<Iterator> sortedStreams) {
        setSortedStreams(sortedStreams);
        //mergering here
    }

    private ListNode mergeKListIterators(){
        if (sortedStreams == null || sortedStreams.size() == 0) return null;
        Comparator<Iterator<Integer>> iteratorComparator = new IteratorComparator();
        PriorityQueue<Iterator<Integer>> priorityQueue = new PriorityQueue<Iterator<Integer>>(sortedStreams.size(), iteratorComparator);

        for (Iterator iterator : sortedStreams){
            if (iterator.hasNext()){
                priorityQueue.add(iterator);
            }
        }

        ListNode head = new ListNode(-999);//temp head to be thrown away
        ListNode p = head;
        while (priorityQueue.size() != 0) {
            Iterator<Integer> current = priorityQueue.poll();
            p.next = new ListNode(-999);
            p.next.val = current.next();
            current.remove();
            p = p.next;
            if (current.hasNext()){
                priorityQueue.add(current);
            }
        }
        return head.next;
    }

    public static void main(String[] args){
        //1,4,7
        List<Integer> list1 = new LinkedList<Integer>(Arrays.asList(1,4,7));
        Iterator<Integer> iterator1 = list1.iterator();

        //2,5,8
        List<Integer> list2 = new LinkedList<Integer>(Arrays.asList(2,5,8));
        Iterator<Integer> iterator2 = list2.iterator();

        //3,6,9
        List<Integer> list3 = new LinkedList<Integer>(Arrays.asList(3,6,9));
        Iterator<Integer> iterator3 = list3.iterator();

        List<Iterator> iteratorList = new ArrayList<Iterator>(3);
        iteratorList.add(iterator1);
        iteratorList.add(iterator2);
        iteratorList.add(iterator3);

        MergingIterator mergingIterator = new MergingIterator(iteratorList);
        ListNode result = mergingIterator.mergeKListIterators();
        while (result!=null){
            System.out.print(result.val);
            result = result.next;
        }

//        while (mergingIterator.hasNext()) {
//            System.out.println(mergingIterator.next());
//        }
    }
}
