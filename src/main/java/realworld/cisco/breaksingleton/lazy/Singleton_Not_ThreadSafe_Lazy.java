package realworld.cisco.breaksingleton.lazy;

/**
 * Author: blueaken
 * Date: 4/14/16 5:30 PM
 */
public class Singleton_Not_ThreadSafe_Lazy {
    //lazy init
    private static Singleton_Not_ThreadSafe_Lazy INSTANCE = null;

    private Singleton_Not_ThreadSafe_Lazy() {
        // Exists only to prevent Singleton object instantiation from outside
    }

    public Singleton_Not_ThreadSafe_Lazy getInstance () {
        if (INSTANCE == null) {
            INSTANCE = new Singleton_Not_ThreadSafe_Lazy();
        }
        return INSTANCE;
    }
}
