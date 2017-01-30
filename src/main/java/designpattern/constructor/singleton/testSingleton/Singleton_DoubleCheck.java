package designpattern.constructor.singleton.testSingleton;

/**
 * Created by jianshen on 11/23/16.
 */
public class Singleton_DoubleCheck {
    private static volatile Singleton_DoubleCheck instance;
    //volatile is required, otherwise issue MIGHT occur when JVM reorder instruction.
    // 潇龙分析 － http://www.cnblogs.com/zuoxiaolong/p/pattern2.html

    private Singleton_DoubleCheck() {}

    public static Singleton_DoubleCheck getInstance() {
        if (instance == null) {
            synchronized (Singleton_DoubleCheck.class) {
                if (instance == null) {
                    instance = new Singleton_DoubleCheck();
                }
            }
        }
        return instance;
    }
}
