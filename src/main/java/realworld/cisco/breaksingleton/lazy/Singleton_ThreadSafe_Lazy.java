package realworld.cisco.breaksingleton.lazy;

/**
 * Author: blueaken
 * Date: 4/14/16 5:56 PM
 */
public class Singleton_ThreadSafe_Lazy {
    //lazy init
    private static Singleton_ThreadSafe_Lazy INSTANCE = null;

    private Singleton_ThreadSafe_Lazy() {
        // Exists only to prevent Singleton object instantiation from outside
    }

    public Singleton_ThreadSafe_Lazy getInstance () {
        if (INSTANCE == null) {
            synchronized (this) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton_ThreadSafe_Lazy();
                }
            }
        }
        return INSTANCE;
    }
}
