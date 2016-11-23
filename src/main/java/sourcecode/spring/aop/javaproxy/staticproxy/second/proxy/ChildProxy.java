package sourcecode.spring.aop.javaproxy.staticproxy.second.proxy;

import sourcecode.spring.aop.javaproxy.staticproxy.second.model.Child;

/**
 * Author: blueaken
 * Date: 2/25/16 11:46 AM
 */
public class ChildProxy implements Child {

    private Child child;

    public ChildProxy(Child child) {
        this.child = child;
    }

    @Override
    public void say() {
        this.child.say();
    }
}
