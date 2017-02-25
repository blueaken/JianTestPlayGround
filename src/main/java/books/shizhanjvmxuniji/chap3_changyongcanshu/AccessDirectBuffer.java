package books.shizhanjvmxuniji.chap3_changyongcanshu;

import java.nio.ByteBuffer;

/**
 * Created by jianshen on 2/24/17.
 */
// 直接内存方法速度会快于堆内存
// 关注第二次的运行成果，第一次作为预热运行
public class AccessDirectBuffer {
    public void directAccess() {
        long starttime = System.currentTimeMillis();
        ByteBuffer b = ByteBuffer.allocateDirect(500);
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 99; j++) {
                b.putInt(j);
            }
            b.flip();
            for (int j = 0; j < 99; j++) {
                b.getInt();
            }
            b.clear();
        }
        long endtime = System.currentTimeMillis();
        System.out.println("testDirectWrite:" + (endtime - starttime));
    }

    public void bufferAccess() {
        long starttime = System.currentTimeMillis();
        ByteBuffer b = ByteBuffer.allocate(500);
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 99; j++) {
                b.putInt(j);
            }
            b.flip();
            for (int j = 0; j < 99; j++) {
                b.getInt();
            }
            b.clear();
        }
        long endtime = System.currentTimeMillis();
        System.out.println("testBufferWrite:" + (endtime - starttime));
    }

    public static void main(String[] args) {
        AccessDirectBuffer alloc = new AccessDirectBuffer();
        alloc.bufferAccess();
        alloc.directAccess();

        System.out.println();

        alloc.bufferAccess();
        alloc.directAccess();
    }
}
