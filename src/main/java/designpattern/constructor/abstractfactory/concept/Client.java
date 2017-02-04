package designpattern.constructor.abstractfactory.concept;

/**
 * Created by jianshen on 1/31/17.
 */
public class Client {
    public static void main(String[] args) {
        IFactory factory1 = new Factory1();
        IProductA productA = factory1.createProductA();
        IProductB productB = factory1.createProductB();
        productA.methodA();
        productB.methodB();

        IFactory factory2 = new Factory2();
        productA = factory2.createProductA();
        productB = factory2.createProductB();
        productA.methodA();
        productB.methodB();
    }
}
