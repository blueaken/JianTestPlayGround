package designpattern.constructor.abstractfactory.concept;

/**
 * Created by jianshen on 1/31/17.
 */
public class Factory2 implements IFactory {
    @Override
    public IProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public IProductB createProductB() {
        return new ProductB2();
    }
}
