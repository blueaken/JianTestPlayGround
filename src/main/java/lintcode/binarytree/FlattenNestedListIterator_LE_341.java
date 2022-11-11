package lintcode.binarytree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator_LE_341 implements Iterator<Integer>  {
    /**
     11.11.2022
     ref labaladong post
     看作一颗N叉树进行遍历
     */

    Iterator<Integer> it;

    public FlattenNestedListIterator_LE_341(List<NestedInteger> nestedList) {
        List<Integer> result = new ArrayList<>();
        for (NestedInteger item : nestedList) {
            traverse(item, result);
        }
        this.it = result.iterator();
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    private void traverse(NestedInteger item, List<Integer> result) {
        if (item.isInteger()) {
            result.add(item.getInteger());
            return;
        }

        for (NestedInteger child : item.getList()) {
            traverse(child, result);
        }
    }
}


 // This is the interface that allows for creating nested lists.
 // You should not implement it, or speculate about its implementation
 interface NestedInteger {

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return empty list if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }

