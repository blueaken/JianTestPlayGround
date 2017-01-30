package designpattern.constructor.singleton.testSingleton;

/**
 * Created by jianshen on 11/23/16.
 */

/*
best version so far, works for JDK versions before 1.5
 */
public class Singleton_InnerClass {

    private Singleton_InnerClass () {}

    public static Singleton_InnerClass getInstance () {
        return Singleton.instance;
    }

    private static class Singleton {
        private static Singleton_InnerClass instance = new Singleton_InnerClass();
    }
}
