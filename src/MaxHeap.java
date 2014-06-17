/**
 * Created with IntelliJ IDEA.
 * User: blueaken
 * Date: 6/15/14
 * Time: 4:39 下午
 */

/**
 * Full and almost full binary heaps may be represented in a very space-efficient way using an array alone. The
 * first (or last) element will contain the root. The next two elements of the array contain its children. The next
 * four contain the four children of the two child nodes, etc. Thus the children of the node at position n would be
 * at positions 2n and 2n+1 in a one-based array, or 2n+1 and 2n+2 in a zero-based array. This allows moving up or
 * down the tree by doing simple index computations. Balancing a heap is done by swapping elements which are out of
 * order. As we can build a heap from an array without requiring extra memory (for the nodes, for example),
 * heap sort can be used to sort an array in-place.
 */

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * btw, great code review on heap sort algorithm: http://codereview.stackexchange.com/questions/32606/implementation-of-heap-sort
 */
public class MaxHeap {
    private int data[];
    private int size;

    public MaxHeap(int data[]) {
        this.data = data;
        this.size = data.length;
        for (int i = size/2-1; i >= 0; i--) {
            heapify(i);
        }
    }

    private int leftChild(int i) { return 2 * i + 1; }

    private int rightChild(int i) { return 2 * i + 2; }

    public static void sort(int data[]) {
        MaxHeap maxHeap = new MaxHeap(data);
        for (int i=data.length-1; i>=0; i--){
            int next = maxHeap.removeNext();
            data[i] = next;
        }
    }

    public int removeNext() throws NoSuchElementException{
        if (size == 0) throw new NoSuchElementException();

        int nextMax = data[0];
        data[0] = data[--size];
        heapify(0);

        return nextMax;
    }

    private void heapify(int i) {
        // You might as well start with this optimistic assumption
        int largestElementIndex = i;

        int l = leftChild(i);
        if (l < size && data[l] > data[largestElementIndex]){
            largestElementIndex = l;
        }

        int r = rightChild(i);
        if (r < size && data[r] > data[largestElementIndex]){
            largestElementIndex = r;
        }

        if (largestElementIndex != i){
            int swap = data[i];
            data[i] = data[largestElementIndex];
            data[largestElementIndex] = swap;

            //recursively heapify the affected subtree
            heapify(largestElementIndex);
        }

    }

    public static void main(String[] args){
        int[] testArray = {3,45,57,23,15,39,78,22,12,22,22};
        System.out.println("before heap sort: " + Arrays.toString(testArray));
        sort(testArray);
        System.out.println("before heap sort: " + Arrays.toString(testArray));
    }

}

