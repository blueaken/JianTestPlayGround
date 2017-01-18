package interviewprep.source1.code81;

import java.util.EmptyStackException;

/**
 * Created by jianshen on 1/17/17.
 */
public class BadStack1 {
    private Object[] elements=new Object[10];
    private int size = 0;

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    private void ensureCapacity(){
        if(elements.length == size){
            Object[] oldElements = elements;
            elements = new Object[2 * elements.length+1];
            System.arraycopy(oldElements,0, elements, 0, size);
        }
    }

    public static void main(String[] args) {
        BadStack1 badStack1 = new BadStack1();
        for (int i = 0; i < 10; i++) {
            badStack1.push(new Object());
        }

        Object[] obj = new Object[10];
        for (int i = 0; i < 10; i++) {
            obj[i] = badStack1.pop();
        }

        System.out.print("end");

    }
}

