package books.shizhanjvmxuniji.chap5_GC_and_memory_alloc;

/**
 * Created by jianshen on 2/25/17.
 */
public class LongFinalize {
    public static class LF {
        private byte[] content = new byte[512];

//        @Override
//        protected void finalize() {
//            try {
//                System.out.println(Thread.currentThread().getId());
//                Thread.sleep(1000);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }

    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            LF f = new LF();
        }
        long e = System.currentTimeMillis();
        System.out.println("total process time: " + (e-s));
    }
}
