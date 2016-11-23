package realworld.ebay;

/**
 * Author: blueaken
 * Date: 1/9/16 9:17 AM
 */
public class SingletonWithDefaultPara {
    private static SingletonWithDefaultPara instance = null;
    private int minLength = 3;
    private int maxLength = 20;

    private SingletonWithDefaultPara() {
        // Exists only to prevent Singleton object instantiation from outside
    }
    public static SingletonWithDefaultPara getInstance() {
        if(instance == null) {
            instance = new SingletonWithDefaultPara();
        }
        return instance;
    }
}
