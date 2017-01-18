package interviewprep.source1.code81;

import java.util.Stack;

/**
 * Created by jianshen on 1/17/17.
 */
public class BadStack2 {
    public static Stack s = new Stack();
//    static{
//        s.push(new Object());
//        s.pop(); //这里有一个对象发生内存泄露
//        s.push(new Object()); //上面的对象可以被回收了,等于是自愈了
//    }

    public static void main(String[] args) {
        s.push(new Object());
        s.pop(); //这里有一个对象发生内存泄露
        s.push(new Object()); //上面的对象可以被回收了,等于是自愈了

        System.out.print("end");
    }
}
