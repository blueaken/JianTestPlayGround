package sourcecode.spring.aop.javaproxy.staticproxy.second;

import sourcecode.spring.aop.javaproxy.staticproxy.second.model.Boy;
import sourcecode.spring.aop.javaproxy.staticproxy.second.model.Child;
import sourcecode.spring.aop.javaproxy.staticproxy.second.model.Girl;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 2/25/16 11:48 AM
 */
public class Test_original {
    public static void main(String[] args){
        Child boy = new Boy();
        Child girl = new Girl();

        List<Child> children = new ArrayList<>();
        children.add(boy);
        children.add(girl);

        for (Child c : children){
            c.say();
        }
    }

}
