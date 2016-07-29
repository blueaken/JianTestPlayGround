package realworld.cisco.breaksingleton;

/**
 * Author: blueaken
 * Date: 4/14/16 5:35 PM
 */
public class Singleton_ThreadSafe_With_Final {
    //eager init
    private static final Singleton_ThreadSafe_With_Final INSTANCE = new Singleton_ThreadSafe_With_Final();

    private Singleton_ThreadSafe_With_Final() {

    }

    public static final Singleton_ThreadSafe_With_Final getInstance() {
        return INSTANCE;
    }
}
