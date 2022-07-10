package lintcode.math;

public class IsRobotRounded_LE_1041 {
    /*
        - most figured by myself, like the idea from solution that simulating turn 'L' by adding 3
     */
    public boolean isRobotBounded(String instructions) {
        int direction = 0; //0 - north, 1 - east, 2 - south, 3 - west
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int x = 0, y = 0;
        for (int i = 0; i < instructions.length(); i++) {
            char cur = instructions.charAt(i);
            switch (cur) {
                case 'G':
                    x += dx[direction];
                    y += dy[direction];
                    break;
                case 'L':
                    direction = (direction + 3) % 4;
                    break;
                case 'R':
                    direction = (direction + 1) % 4;
                    break;
                default:
                    break;
            }
        }

        if (x == 0 && y == 0 || direction != 0) {
            //return true if moved or direction changes
            return true;
        } else {
            return false;
        }
    }
}
