package sourcecode.spring.aop.javaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author jianshen
 */
public class MyInvocationHandler implements InvocationHandler {
    /**
     * 替换外部class调用的方法
     * obj        外部已经已经包装好InvocationHandler的实例
     * method    外部方法
     * args        方法参数
     */
    public Object invoke(Object obj, Method method, Object[] args) throws Throwable{
        String s1[] = {"blueaken"};
        String s2[] = {"anyone"};

        IMyAOP myAOP = new MyAOP();
        System.out.println("start!");
        method.invoke(myAOP, args);
        method.invoke(myAOP, s1);
        method.invoke(myAOP, s2);
        System.out.println("stop!");

        return null;
    }

}
