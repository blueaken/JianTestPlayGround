package designpattern.constructor.simplefactory.concept;

/**
 * Created by jianshen on 1/30/17.
 */
public class Client {
    public static void main(String[] args) {
        String input = "ProductA";
        SimpleFactory simpleFactory = new SimpleFactory();
        IProduct product = simpleFactory.create(input);
        product.method();
    }
}
