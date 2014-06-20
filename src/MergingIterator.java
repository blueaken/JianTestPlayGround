import java.util.*;

class IteratorComparator implements Comparator<Iterator<Integer>> {
    @Override
    public int compare(Iterator<Integer> a, Iterator<Integer> b){
        return a.next() - b.next();
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

    private List mergeKListIterators(){
        if (sortedStreams == null || sortedStreams.size() == 0) return null;
        Comparator<Iterator<Integer>> iteratorComparator = new IteratorComparator();
        PriorityQueue<Iterator<Integer>> priorityQueue = new PriorityQueue<Iterator<Integer>>(sortedStreams.size(), iteratorComparator);

        for (Iterator iterator : sortedStreams){
            if (iterator.hasNext()){
                priorityQueue.add(iterator);
            }
        }

//        ListNode head = new ListNode(-999);//temp head to be thrown away
//        ListNode p = head;
//        while (priorityQueue.size() != 0) {
//            Iterator<Integer> current = priorityQueue.poll();
//            p.next = current;
//            p = p.next;
//            if (current.hasNext()){
//                priorityQueue.add((Iterator<Integer>)current.next());
//            }
//        }
//        return head.next;
    }

    public static void main(String[] args){
        //1,4,7
        List<Integer> list1 = new ArrayList<Integer>(3);
        list1 = Arrays.asList(1,4,7);
        Iterator<Integer> iterator1 = list1.iterator();

        //2,5,8
        List<Integer> list2 = new ArrayList<Integer>(3);
        list2 = Arrays.asList(2,5,8);
        Iterator<Integer> iterator2 = list2.iterator();

        //3,6,9
        List<Integer> list3 = new ArrayList<Integer>(3);
        list3 = Arrays.asList(3,6,9);
        Iterator<Integer> iterator3 = list3.iterator();

        List<Iterator> iteratorList = new ArrayList<Iterator>(3);
        iteratorList.add(iterator1);
        iteratorList.add(iterator2);
        iteratorList.add(iterator3);

        MergingIterator mergingIterator = new MergingIterator(iteratorList);
//        while (mergingIterator.hasNext()) {
//            System.out.println(mergingIterator.next());
//        }
    }
}
