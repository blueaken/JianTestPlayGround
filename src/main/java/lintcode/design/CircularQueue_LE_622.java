package lintcode.design;

public class CircularQueue_LE_622 {
    /**
     1.19.24
     */
    int[] arr;
    int front, end;
    public CircularQueue_LE_622(int k) {
        arr = new int[k];
        front = -1;
        end = -1;
    }

    public boolean enQueue(int value) {
        if (isEmpty()) {
            front = 0;
            end = 0;
            arr[end] = value;
            return true;
        }

        if (isFull()) {
            return false;
        }

        // normal enQueue operation
        int next = (end+1) % arr.length;
        arr[next] = value;
        end = next;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        // if only one element left then empty the queue
        if (front == end) {
            front = -1;
            end = -1;
            return true;
        }

        // normal deQueue operation
        front = (front+1) % arr.length;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[end];
    }

    public boolean isEmpty() {
        return front == -1 && end == -1;
    }

    public boolean isFull() {
        return (end + 1) % arr.length == front;
    }

    public static void main(String[] args) {
        CircularQueue_LE_622 queue = new CircularQueue_LE_622(6);
        System.out.println(queue.enQueue(6));
        System.out.println(queue.Rear());
        System.out.println(queue.Rear());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(5));
        System.out.println(queue.Rear());
        System.out.println(queue.deQueue());
        System.out.println(queue.Front());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }
}
