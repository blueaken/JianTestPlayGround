package realworld.cisco.breaksingleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Author: blueaken
 * Date: 4/14/16 5:35 PM
 */
public class Singleton_ThreadSafe_With_Final_Solid implements Serializable {
    //eager init
    private static final Singleton_ThreadSafe_With_Final_Solid INSTANCE = new Singleton_ThreadSafe_With_Final_Solid();

    private Singleton_ThreadSafe_With_Final_Solid() {
        // Check if we already have an instance
        if (INSTANCE != null) {
            throw new IllegalStateException("Singleton" + " instance already created.");
        }
    }

    public static final Singleton_ThreadSafe_With_Final_Solid getInstance() {
        return INSTANCE;
    }

    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }

    public Object clone() throws CloneNotSupportedException {
        // return INSTANCE
        throw new CloneNotSupportedException();
    }


}
