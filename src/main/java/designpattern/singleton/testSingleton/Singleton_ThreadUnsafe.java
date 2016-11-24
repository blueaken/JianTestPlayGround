package designpattern.singleton.testSingleton;

/**
 * Created by jianshen on 11/22/16.
 */
public class Singleton_ThreadUnsafe {
    //一个静态的实例
    private static Singleton_ThreadUnsafe singletonThreadUnsafe;
    //私有化构造函数
    private Singleton_ThreadUnsafe(){}
    //给出一个公共的静态方法返回一个单一实例
    public static Singleton_ThreadUnsafe getInstance(){
        if (singletonThreadUnsafe == null) {
            singletonThreadUnsafe = new Singleton_ThreadUnsafe();
        }
        return singletonThreadUnsafe;
    }
}
