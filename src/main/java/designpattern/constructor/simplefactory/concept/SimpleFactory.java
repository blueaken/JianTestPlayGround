package designpattern.constructor.simplefactory.concept;

/**
 * Created by jianshen on 1/30/17.
 */
public class SimpleFactory {
    public IProduct create(String product) {
        if ("ProductA".equalsIgnoreCase(product))  {
            return new ProductA();
        } else {
            return new ProductB();
        }
    }
}
