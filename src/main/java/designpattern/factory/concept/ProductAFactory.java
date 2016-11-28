package designpattern.factory.concept;

/**
 * Created by jianshen on 11/27/16.
 */
public class ProductAFactory implements IFactory {
    public IProduct create() {
        return new ProductA();
    }
}
