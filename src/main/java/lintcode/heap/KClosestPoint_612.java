package lintcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

import type.Point;

public class KClosestPoint_612 {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    Point global_origin;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        global_origin = origin;
        PriorityQueue<Point> heap = new PriorityQueue<Point> (k, new Comparator<Point> () {
            @Override
            public int compare(Point a, Point b) {
                int diff = getDistance(a, global_origin) - getDistance(b, global_origin);
                if (diff == 0) {
                    int x_diff = a.x - b.x;
                    if (x_diff != 0) {
                        return x_diff;
                    } else {
                        return a.y - b.y;
                    }
                } else {
                    return diff;
                }
            }
        });

        for (int i = 0; i < points.length; i++) {
            heap.offer(points[i]);
        }

        Point[] res = new Point[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }

    private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    public static void main(String[] args) {
        Point[] p = {new Point(4, 6), new Point(4, 7), new Point(4, 4), new Point(2, 5), new Point(1, 1)};
        Point origin = new Point(0, 0);
        int k = 3;

        KClosestPoint_612 solution = new KClosestPoint_612();
        Point[] res = solution.kClosest(p, origin, k);
        System.out.println(res);
    }
}

