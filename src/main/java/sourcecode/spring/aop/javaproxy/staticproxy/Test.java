package sourcecode.spring.aop.javaproxy.staticproxy;

import sourcecode.spring.aop.javaproxy.staticproxy.model.Boy;
import sourcecode.spring.aop.javaproxy.staticproxy.model.Child;
import sourcecode.spring.aop.javaproxy.staticproxy.model.Girl;
import sourcecode.spring.aop.javaproxy.staticproxy.proxy.ChildProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 2/1/16 2:00 PM
 */
public class Test {
    public static void main(String[] args){
        List<Child> children= new ArrayList<>();

        //把Boy和Girl的对象，交给ProxyChild对象代理
        children.add(new ChildProxy(new Boy()));
        children.add(new ChildProxy(new Girl()));

        for(Child c : children){
            c.say();
        }
    }
}
