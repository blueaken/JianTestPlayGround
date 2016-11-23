package sourcecode.spring.aop.javaproxy.staticproxy.second.model;

/**
 * Author: blueaken
 * Date: 2/25/16 11:38 AM
 */
public class Boy implements Child {
    @Override
    public void say(){
        System.out.println("Boy says hello!");
    }
}
