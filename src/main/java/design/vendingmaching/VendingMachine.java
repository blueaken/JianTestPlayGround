package design.vendingmaching;

import design.vendingmaching.coin.Coin;
import design.vendingmaching.product.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 12/22/15 8:27 AM
 */
public class VendingMachine {
    private Map<Product, Integer> inventory = new HashMap<>();

    public VendingMachine(Map<Product, Integer> inventory) {
        this.inventory = inventory;
    }

    public void checkInventory() {
        if (inventory.size()==0) System.out.println("There is no inventory now, loading is needed.");
        else {
            for (Product p : inventory.keySet()) {
                System.out.println(p.toString() + " and number is "+ inventory.get(p));
            }
        }
    }

    public void setInventory(Map<Product, Integer> inventory) {
        this.inventory = inventory;
    }

    public void buy(Product product, List<Coin> coins){
        if (inventory.containsKey(product) && inventory.get(product)>0){
            int coinsValue = getCoinsValue(coins);
            if (coinsValue >= product.getPrice()){
                inventory.put(product, inventory.get(product)-1);
                System.out.println("The purchase of "+ product.toString() + " succeed.");
            } else {
                System.out.println("Sorry need more coins.");
            }
        } else {
            System.out.println("Sorry "+ product.toString() + " is sold out.");
        }
    }

    private int getCoinsValue(List<Coin> coins){
        int sum = 0;
        for (Coin c : coins){
            sum+=c.getValue();
        }
        return sum;
    }
}
