package ninechapter_algorithm.chapter8_data_structure.mergeksortedarrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Author: blueaken
 * Date: 5/3/16 09:26
 */
class Element {
    int row;
    int col;
    int val;

    Element(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

class ElementComparator implements Comparator<Element> {
    @Override
    public int compare(Element a, Element b) {
        return a.val - b.val;
    }
}

public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        if (arrays == null || arrays.length == 0
                || arrays[0] == null || arrays[0].length == 0) {
            return result;
        }

        int row = arrays.length;
        PriorityQueue<Element> pq = new PriorityQueue<>(row, new ElementComparator());

        for (int i = 0; i < row; i++) {
            if (arrays[i].length > 0) {
                Element element = new Element(i, 0, arrays[i][0]);
                pq.add(element);
            }
        }

        while (pq.size() > 0) {
            Element cur = pq.poll();
            result.add(cur.val);

            int newCol = cur.col + 1;
            if (arrays[cur.row].length > newCol) {
                Element newElem = new Element(cur.row, newCol, arrays[cur.row][newCol]);
                pq.add(newElem);
            }
        }

        return result;
    }
}
