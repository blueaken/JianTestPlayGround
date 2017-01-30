package designpattern.constructor.factory.concept;

/**
 * Created by jianshen on 11/27/16.
 */
public class Client {
    public static void main(String[] args) {
        IFactory factoryA = new ProductAFactory();
        IProduct product1 = factoryA.create();
        product1.print();

        IFactory factoryB = new ProductBFactory();
        IProduct product2 = factoryB.create();
        product2.print();
    }
}
