package sourcecode.spring.aop.javaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author jianshen
 */
public class Test {
    public static void main(String args[]){
        Class clazz = new MyAOP().getClass();
        ClassLoader cl = clazz.getClassLoader();
        Class classes[] = clazz.getInterfaces();

        InvocationHandler ih = new MyInvocationHandler();

        //用InvocationHandler给MyAOP进行AOP包装
        IMyAOP myAOP = (IMyAOP) Proxy.newProxyInstance(cl, classes, ih);
        myAOP.print("test");
        System.out.println();
        myAOP.write("test");
    }
}
