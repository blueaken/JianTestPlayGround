package realworld.ebay;

/**
 * Author: blueaken
 * Date: 1/9/16 8:35 AM
 */
public class SimpleSingleton {
    /*
     * 1st version: not thready safe
     */
    private static SimpleSingleton instance = null;
    private SimpleSingleton() {
        // Exists only to prevent Singleton object instantiation from outside
    }
    public static SimpleSingleton getInstance() {
        if(instance == null) {
            instance = new SimpleSingleton();
        }
        return instance;
    }
}
