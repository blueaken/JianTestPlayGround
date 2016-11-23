package realworld.ebay;

/**
 * Author: blueaken
 * Date: 1/9/16 8:57 AM
 */
public class Singleton_2nd {
    /* 2nd version : this definitely thread-safe and only
     * creates one instance of Singleton on concurrent environment
     * but unnecessarily expensive due to cost of synchronization
     * at every call.
     */

    private static Singleton_2nd instance = null;
    private Singleton_2nd() {
        // Exists only to prevent Singleton object instantiation from outside
    }

    public static synchronized Singleton_2nd getInstanceTS() {
        if(instance == null) {
            instance = new Singleton_2nd();
        }
        return instance;
    }
}
