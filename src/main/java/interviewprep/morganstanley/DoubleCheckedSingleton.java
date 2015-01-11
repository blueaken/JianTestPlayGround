package interviewprep.morganstanley;

/**
 * Created by jianshen on 1/10/15.
 */
/*
 * I like explanation on stackoverflow - if 2 threads hit the first check at the same time, both trying to get the
 * lock since INSTANCE is null. However, only one thread will get the lock and instantiate the INSTANCE and release
 * the lock; at this time the other thread gets the lock and run the 2nd check and found the INSTANCE is already
 * instantiated (note "volatile" plays here, it is introduced after Java 1.5), it then returns the INSTANCE.
 *
 * The benefit of double Checked Singleton is it only synchronized critical path, which is very efficient comparing
 * with synchronized the whole getInstance() method.
 *
 * ref: http://stackoverflow.com/questions/18093735/double-checked-locking-in-singleton
 */
public class DoubleCheckedSingleton {
    private static volatile DoubleCheckedSingleton INSTANCE;

    private DoubleCheckedSingleton(){

    }

    public DoubleCheckedSingleton getInstance(){
        if (INSTANCE == null){                     //first check w/o lock
            synchronized (DoubleCheckedSingleton.class){
                if (INSTANCE == null){             //second check with lock
                    INSTANCE = new DoubleCheckedSingleton();
                }
            }
        }

        return INSTANCE;

    }
}
