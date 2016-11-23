package designpattern.chainofresponsibility.basemodel;

/**
 * Author: blueaken
 * Date: 3/7/16 3:18 PM
 */
public class ClientTest {
    public static void main(String[] args) {
        //组装责任链
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        handler1.setSuccessor(handler2);
        //提交请求
        handler1.handleRequest();
    }
}
