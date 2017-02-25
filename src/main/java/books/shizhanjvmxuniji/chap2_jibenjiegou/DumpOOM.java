package books.shizhanjvmxuniji.chap2_jibenjiegou;

import java.util.Vector;

/**
 * Created by jianshen on 2/24/17.
 */
public class DumpOOM {
    public static void main(String[] args) {
        //request 25M heap memory on a 20M size Heap
        //run with VM options: -Xmx20m -Xms5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/jianshen/log/oom.dump
        Vector v = new Vector();
        for (int i = 0; i < 25; i++) {
            v.add(new byte[1 * 1024 * 1024]);
        }
    }
}
