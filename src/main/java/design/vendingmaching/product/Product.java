package design.vendingmaching.product;

/**
 * Author: blueaken
 * Date: 12/22/15 9:50 PM
 */
public abstract class Product {
    protected String name;
    protected int price;

    public int getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return "Product name: " + this.name + ", price is: " + this.price + ".";
    }
}
