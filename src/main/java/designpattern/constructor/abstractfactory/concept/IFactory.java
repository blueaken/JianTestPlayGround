package designpattern.constructor.abstractfactory.concept;

/**
 * Created by jianshen on 1/31/17.
 */
public interface IFactory {
    IProductA createProductA();
    IProductB createProductB();
}
