package designpattern.strategy.basemodel;

/**
 * Author: blueaken
 * Date: 3/7/16 11:30 AM
 */
public class Client {
    public static void main(String[] args) {
        //选择并创建需要使用的策略对象
        Strategy strategy = new ConcreteStrategyA();
        //创建环境
        Context evn = new Context(strategy);
        //执行
        evn.contextInterface();
    }
}
