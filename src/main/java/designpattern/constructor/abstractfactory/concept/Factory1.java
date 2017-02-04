package designpattern.constructor.abstractfactory.concept;

/**
 * Created by jianshen on 1/31/17.
 */
public class Factory1 implements IFactory {
    @Override
    public IProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public IProductB createProductB() {
        return new ProductB1();
    }
}
