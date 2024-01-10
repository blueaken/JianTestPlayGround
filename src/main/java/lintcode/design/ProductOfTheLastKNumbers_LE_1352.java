package lintcode.design;

import java.util.*;

public class ProductOfTheLastKNumbers_LE_1352 {
    /**
     1.10.24
     - ref 东哥思路，more elegant
     */
    LinkedList<Integer> prefix;
    public ProductOfTheLastKNumbers_LE_1352() {
        prefix = new LinkedList<>();
        prefix.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            prefix.clear();
            prefix.add(1);
        } else {
            prefix.add(prefix.getLast() * num);
        }
    }

    public int getProduct(int k) {
        int size = prefix.size();
        if (k > size-1) { // skip the head value 1
            return 0;
        } else {
            return prefix.get(size-1) / prefix.get(size - 1 - k);
        }
    }

    public static void main(String[] args) {
        ProductOfTheLastKNumbers_LE_1352 solution = new ProductOfTheLastKNumbers_LE_1352();
        solution.add(3);
        solution.add(0);
        solution.add(2);
        solution.add(5);
        solution.add(4);
        System.out.println(solution.getProduct(2));//20
        System.out.println(solution.getProduct(3));//40
        System.out.println(solution.getProduct(4));//0
        solution.add(8);
        System.out.println(solution.getProduct(2));//32
    }
}
