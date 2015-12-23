package design.vendingmaching;

import design.vendingmaching.coin.Coin;
import design.vendingmaching.coin.OneCent;
import design.vendingmaching.coin.TwoCent;
import design.vendingmaching.product.Chips;
import design.vendingmaching.product.Coke;
import design.vendingmaching.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 12/23/15 12:16 AM
 */
public class Test {
    public static void main(String[] args){
        Map<Product, Integer> inventory = new HashMap<>();
        Coke coke = new Coke();
        Chips chips = new Chips();
        inventory.put(coke, 5);
        inventory.put(chips, 5);

        OneCent oneCentCoin = new OneCent();
        //TwoCent twoCentCoin = new TwoCent();
        List<Coin> coins = new ArrayList<>();
        coins.add(oneCentCoin);
        coins.add(oneCentCoin);

        VendingMaching vendingMaching = new VendingMaching(inventory);
        vendingMaching.checkInventory();
        vendingMaching.buy(coke, coins);
        vendingMaching.checkInventory();
    }


}
