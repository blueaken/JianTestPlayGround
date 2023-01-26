package lintcode.others.geometry;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PerfectRectangle_LE_391 {
    /**
     1.26.2023
     - ref 东哥 post, 从面积和顶点2方面来验证
     - 注意Point class需要重写equals和hashcode方法来使Set class的contains方法工作
     */
    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public boolean isRectangleCover(int[][] rectangles) {
        int[] point_BL = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] point_UR = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE};
        int actual_area = 0;

        Set<Point> pointSet = new HashSet<>();

        for (int[] points : rectangles) {
            point_BL[0] = Math.min(points[0], point_BL[0]);
            point_BL[1] = Math.min(points[1], point_BL[1]);
            point_UR[0] = Math.max(points[2], point_UR[0]);
            point_UR[1] = Math.max(points[3], point_UR[1]);
            actual_area += (points[2] - points[0]) * (points[3] - points[1]);

            // 保留出现奇数次的point
            Set<Point> rectangle_points = new HashSet<>();
            rectangle_points.add(new Point(points[0], points[1]));
            rectangle_points.add(new Point(points[0], points[3]));
            rectangle_points.add(new Point(points[2], points[1]));
            rectangle_points.add(new Point(points[2], points[3]));

            for (Point p : rectangle_points) {
                if (pointSet.contains(p)) {
                    pointSet.remove(p);
                } else {
                    pointSet.add(p);
                }
            }
        }

        int expected_area = (point_UR[0] - point_BL[0]) * (point_UR[1] - point_BL[1]);
        if (expected_area != actual_area) {
            return false;
        }

        //verify the 4 points left are the perfect rectangle points
        Point pBL = new Point(point_BL[0], point_BL[1]);
        Point pUL = new Point(point_BL[0], point_UR[1]);
        Point pBR = new Point(point_UR[0], point_BL[1]);
        Point pUR = new Point(point_UR[0], point_UR[1]);

        if (pointSet.size() != 4) {
            return false;
        }

        if (!pointSet.contains(pBL)
                || !pointSet.contains(pUL)
                || !pointSet.contains(pBR)
                || !pointSet.contains(pUR)) {
            return false;
        }

        return true;
    }

//    boolean test() {
//        Point p1 = new Point(1,1);
//        Point p2 = new Point(1,1);
////        boolean r1 = p1.equals(p2);
//
//        Set<Point> s1 = new HashSet<>();
//        s1.add(p1);
//        s1.add(p2);
//        return s1.size() == 1;
//    }

    public static void main(String[] args) {

        PerfectRectangle_LE_391 solution = new PerfectRectangle_LE_391();
//        System.out.println(solution.test());

        int[][] rectangles = {
            {1,1,3,3}, {3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}
        };

        System.out.println(solution.isRectangleCover(rectangles));
    }
}
