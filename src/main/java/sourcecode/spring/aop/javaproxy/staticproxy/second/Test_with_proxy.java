package sourcecode.spring.aop.javaproxy.staticproxy.second;

import sourcecode.spring.aop.javaproxy.staticproxy.second.model.Boy;
import sourcecode.spring.aop.javaproxy.staticproxy.second.model.Child;
import sourcecode.spring.aop.javaproxy.staticproxy.second.model.Girl;
import sourcecode.spring.aop.javaproxy.staticproxy.second.proxy.ChildProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 2/25/16 11:51 AM
 */
public class Test_with_proxy {
    public static void main(String[] args){
        Child boy = new Boy();
        Child girl = new Girl();

        ChildProxy boyProxy = new ChildProxy(boy);
        ChildProxy girlProxy = new ChildProxy(girl);

        List<Child> children = new ArrayList<>();
        children.add(boyProxy);
        children.add(girlProxy);

        for (Child c : children){
            c.say();
        }
    }
}
