package sourcecode.spring.aop.javaproxy.staticproxy.second.model;

/**
 * Author: blueaken
 * Date: 2/25/16 11:44 AM
 */
public class Girl implements Child {
    @Override
    public void say(){
        System.out.println("Girl says Hello!");
    }
}
