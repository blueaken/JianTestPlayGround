package lintcode.heap;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class SkylineBuilding_LE_218 {

    class BuildingPoint implements Comparable<BuildingPoint> {
        int x;
        int height;
        boolean isStart;

        @Override
        public int compareTo(@NotNull BuildingPoint o) {
            //first compare x, if equals use the following logic:
            //if two starts are compared, then select the higher building
            //if two ends are compared, then select the lower building
            //if one start and one end is compared, then select the start point
            int diff = this.x - o.x;
            if (diff == 0) {
                if (this.isStart && o.isStart) {
                    return o.height - this.height;
                }
                else if (!this.isStart && !o.isStart) {
                    return this.height - o.height;
                } else if (this.isStart) {
                    return -1; //select this
                } else {
                    return 1; //select o
                }

            } else {
                return diff;
            }
        }
    }

    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    /*
        Idea: ref Tushor's video - https://www.youtube.com/watch?v=GSBLe8cKu0s & KClosestPoint_612,
             refactor the TreeMap to PriorityQueue and the compareTo method for practice purpose
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // write your code here
        //make building points array, the length is twice the buildings array, since 1 for start point and the other for end point
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];
        int index = 0;
        for (int[] building : buildings) {
            buildingPoints[index] = new BuildingPoint();
            buildingPoints[index].x = building[0];
            buildingPoints[index].height = building[2];
            buildingPoints[index].isStart = true;

            buildingPoints[index + 1] = new BuildingPoint();
            buildingPoints[index + 1].x = building[1];
            buildingPoints[index + 1].height = building[2];
            buildingPoints[index + 1].isStart = false;
            index += 2;
        }
        Arrays.sort(buildingPoints);

        //can use TreeMap which provides log time performance of all insert, update, remove methods
        //PriorityQueue in Java does not support remove(object) operation in log time, here use PriorityQueue for practice
        //TreeMap<Integer, Integer> queue = new TreeMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(0); //init to 0 for ease of coding
        int preMaxHeight = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (BuildingPoint buildingPoint : buildingPoints) {
            //if it is the start of building then add it to the queue
            if (buildingPoint.isStart) {
                maxHeap.offer(buildingPoint.height);
            } else {// if it is the end of building, then remove it from the heap
                maxHeap.remove(buildingPoint.height);
            }
            // peek the current height after add/remove the of Building Point
            int curMaxHeight = maxHeap.peek();
            // if max height changes, then this building point becomes critical and add it to the result
            if (preMaxHeight != curMaxHeight) {
                List<Integer> list = new ArrayList<>();
                list.add(buildingPoint.x);
                list.add(curMaxHeight);
                res.add(list);
                preMaxHeight = curMaxHeight;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        //{start, end, height}
        int[][] buildings = {{1,3,4},{3,4,4},{2,6,2},{8,11,4},{7,9,3},{10,11,2}};//expect [[1, 4], [4, 2], [6, 0], [7, 3], [8, 4], [11, 0]]

        SkylineBuilding_LE_218 solution = new SkylineBuilding_LE_218();
        System.out.println(solution.getSkyline(buildings));
    }
}
