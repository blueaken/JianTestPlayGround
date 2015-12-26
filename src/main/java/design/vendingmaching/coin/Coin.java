package design.vendingmaching.coin;

/**
 * Author: blueaken
 * Date: 12/22/15 8:28 AM
 */
public abstract class Coin {
    protected String name;
    protected int value;

    public int getValue() {
        return value;
    }

    @Override
    public String toString(){
        return "Product name: " + this.name + ", value is: " + this.value + ".";
    }
}
