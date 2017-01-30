package designpattern.constructor.factory.concept;

/**
 * Created by jianshen on 11/27/16.
 */
public class ProductBFactory implements IFactory{
    public IProduct create () {
        return new ProductB();
    }
}
