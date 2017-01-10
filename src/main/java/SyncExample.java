import java.util.Date;

/**
 * Created by jshe18 on 11/24/15.
 */
public class SyncExample {

    public static class Thingie {
        private Date lastAccess;
        public synchronized void setLastAccess(Date date) {
            this.lastAccess = date;
        }
    }
    public static class MyThread extends Thread {
        private Thingie thingie;
        public MyThread(Thingie thingie) {
            this.thingie = thingie;
        }
        public void run() {
            thingie.setLastAccess(new Date());
        }
    }
    public static void main(String[] args) {
        Thingie thingie1 = new Thingie();
        Thingie thingie2 = new Thingie();
        new MyThread(thingie1).start();
        new MyThread(thingie2).start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }

        System.out.print("for debug");
    }
}
