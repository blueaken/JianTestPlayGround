package lintcode.mathmatics;

public class LargestTriangleArea_1005 {
    /**
     * @param points: List[List[int]]
     * @return: return a double
     */
    //Idea: 由于只有50个点，使用枚举法。
    //      三角形根据顶点求面积公式：S = Math.abs(x1(y2-y3) + x2(y3-y1) + x3(y1-y2))/2,
    //       Ref - https://zhuanlan.zhihu.com/p/25793392
    public double largestTriangleArea(int[][] points) {
        // write your code here
        if (points == null || points[0] == null) {
            return 0.0;
        }

        int len = points.length;
        double max = 0.0;
        for (int i = 0; i < len-2; i++) {
            for (int j = i+1; j < len-1; j++) {
                for (int k = j+1; k < len; k++) {
                    max = Math.max(max, calTriArea(points[i], points[j], points[k]));
                }
            }
        }
        return max;
    }

    private double calTriArea (int[] p1, int[] p2, int[] p3) {
        return 0.5 * (Math.abs(p1[0] * (p2[1] - p3[1]) + p2[0] * (p3[1] - p1[1]) + p3[0] * (p1[1] - p2[1])));
    }
}
