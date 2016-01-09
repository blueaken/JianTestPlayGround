package realworld.ebay;

/**
 * Author: blueaken
 * Date: 1/9/16 9:01 AM
 */
public class Singleton_3rd {

    /*
     * 3rd version : An implementation of double checked locking of Singleton.
     * Intention is to minimize cost of synchronization and improve performance,
     * by only locking critical section of code, the code which creates instance of Singleton class.
     * By the way this is still broken, if we don't make instance volatile, as another thread can
     * see a half initialized instance of Singleton.
     */

    private volatile static Singleton_3rd instance = null;
    private Singleton_3rd() {
        // Exists only to prevent Singleton object instantiation from outside
    }

    public static Singleton_3rd getInstanceDC() {
        if(instance == null) {
            synchronized (Singleton_3rd.class) {
                if (instance == null) {
                    instance = new Singleton_3rd();
                }
            }
        }
        return instance;
    }
}
