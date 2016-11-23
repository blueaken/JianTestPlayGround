package sourcecode.spring.aop.javaproxy.staticproxy.proxy;

import sourcecode.spring.aop.javaproxy.staticproxy.model.Child;

/**
 * Author: blueaken
 * Date: 2/1/16 2:01 PM
 */
public class ChildProxy implements Child {
    private Child child;

    public ChildProxy(Child child) {
        this.child = child;
    }

    @Override
    public void say(){
        this.child.say();
    }
}
