package lintcode.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    - gut shot idea, no optimization, got TLE
*/
public class FindMedianFromDataStream_LE_295 {
    private List<Integer> data;
    private int count;

    public FindMedianFromDataStream_LE_295() {
        this.data = new ArrayList<>();
        this.count = 0;
    }

    //O(NLogN) per input, to the data stream is O(N^2)
    public void addNum(int num) {
        data.add(num);
        Collections.sort(data);
        count++;
    }

    //O(1)
    public double findMedian() {
        boolean isEven = count % 2 == 0;
        if (isEven) {
            return (double)(data.get(count / 2 - 1) + data.get(count / 2)) / 2;
        } else {
            return (double)(data.get(count / 2));
        }
    }

    public static void main(String[] args) {
        FindMedianFromDataStream_LE_295 solution = new FindMedianFromDataStream_LE_295();
        solution.addNum(1);
        solution.addNum(2);
        System.out.println(solution.findMedian()); //1.50
        solution.addNum(3);
        System.out.println(solution.findMedian()); //2.00
    }
}
