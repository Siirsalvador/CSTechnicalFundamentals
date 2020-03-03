package PhoneScreens.Palantir.FloodMap;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-20
 */
public class FloodMap {

    public static void main(String[] args) {

        int[][] grid = {
                {1, 2, 3},
                {4, 5, 8},
                {9, 7, 0}
        };


//        System.out.println(Arrays.deepToString(findHighPoints1(grid)));
        System.out.println(Arrays.deepToString(findHighPoints2(grid)));

        int[][] grid2 = {
                {1, 2, 3, 4},
                {5, 5, 5, 2},
                {1, 1, 1, 1},
                {0, 0, 0, 9}
        };

        System.out.println(Arrays.deepToString(findHighPlateaus(grid2)));
    }

    /*
     *
     * #1. Given a 2D map of integers representing the elevation point of a ground, find all "High Points" defined as follows:
     * The maximum point which is strictly greater than all of the adjacent neighbours. The adjacent neighbours are in 8 directions.
     * Your function should return NxM matrix of ones/zeros. Ones if that point is a "High Point" in the corresponding elevation map
     *
     */
    public static int[][] findHighPoints1(int[][] map) {

        int[][] res = new int[map.length][map[0].length];

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                int currNum = map[row][col];
                res[row][col] = 1;

                //Top
                if (row - 1 >= 0 && map[row - 1][col] > currNum) {
                    res[row][col] = 0;
                }

                //Bottom
                if (row + 1 < map.length && map[row + 1][col] > currNum) {
                    res[row][col] = 0;
                }

                //Left
                if (col - 1 >= 0 && map[row][col - 1] > currNum) {
                    res[row][col] = 0;
                }

                //Right
                if (col + 1 < map[0].length && map[row][col + 1] > currNum) {
                    res[row][col] = 0;
                }

                //LT Diagonal
                if (row - 1 >= 0 && col - 1 >= 0 && map[row - 1][col - 1] > currNum) {
                    res[row][col] = 0;
                }

                //RT Diagonal
                if (row - 1 >= 0 && col + 1 < map[0].length && map[row - 1][col + 1] > currNum) {
                    res[row][col] = 0;
                }

                //LB Diagonal
                if (row + 1 < map.length && col - 1 >= 0 && map[row + 1][col - 1] > currNum) {
                    res[row][col] = 0;
                }

                //RB Diagonal
                if (row + 1 < map.length && col + 1 < map[0].length && map[row + 1][col + 1] > currNum) {
                    res[row][col] = 0;
                }

            }
        }

        return res;
    }

    /*
     * 2. Using the previous function on # 1. you are then tasked to mark flooded area if water came from the "High Point".
     * Specifically, flood fill starting from a "High Point" all adjacent point that is strictly less than the flooded cell.
     * The flooded cell start from a "High Point" and spread to the neighbouring with rule: to flood other cell,
     * the elevation point of the other cell must be stricly lower. The problem statement is more or less like the above.
     *
     */
    public static int[][] findHighPoints2(int[][] map) {

        int[][] highPoints = findHighPoints1(map);
        int[][] floodRes = highPoints;

        for (int row = 0; row < highPoints.length; row++) {
            for (int col = 0; col < highPoints[0].length; col++) {

                if (highPoints[row][col] == 1) {
                    highPoints[row][col] = 0;
                    HashSet<String> set = new HashSet<>();

                    int compare = map[row][col];
                    floodFill(floodRes, row, col, set, map, compare);
                }

            }
        }

        return floodRes;
    }

    private static void floodFill(int[][] floodRes, int row, int col, HashSet<String> visited, int[][] map, int compare) {

        String key = row + "." + col;

        if (map[row][col] <= compare && !visited.contains(key)) {
            floodRes[row][col] += 1;
            visited.add(key);

            //Top
            if (row - 1 >= 0) {
                floodFill(floodRes, row - 1, col, visited, map, compare);
            }

            //Bottom
            if (row + 1 < map.length) {
                floodFill(floodRes, row + 1, col, visited, map, compare);
            }

            //Left
            if (col - 1 >= 0) {
                floodFill(floodRes, row, col - 1, visited, map, compare);
            }

            //Right
            if (col + 1 < map[0].length) {
                floodFill(floodRes, row, col + 1, visited, map, compare);
            }

            //LT Diagonal
            if (row - 1 >= 0 && col - 1 >= 0) {
                floodFill(floodRes, row - 1, col - 1, visited, map, compare);
            }

            //RT Diagonal
            if (row - 1 >= 0 && col + 1 < map[0].length) {
                floodFill(floodRes, row - 1, col + 1, visited, map, compare);
            }

            //LB Diagonal
            if (row + 1 < map.length && col - 1 >= 0) {
                floodFill(floodRes, row + 1, col - 1, visited, map, compare);
            }

            //RB Diagonal
            if (row + 1 < map.length && col + 1 < map[0].length) {
                floodFill(floodRes, row + 1, col + 1, visited, map, compare);
            }
        }
    }


    /*
     * 3. Find High Plateau: same level, no neighbors(8 neighbors) are higher than any points of this plateau. return a matrix of the plateau.
     * */
    public static int[][] findHighPlateaus(int[][] map) {

        int[][] res = new int[map.length][map[0].length];

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                int currNum = map[row][col];
                res[row][col] = 1;

                //Top
                if (row - 1 >= 0 && map[row - 1][col] > currNum) {
                    res[row][col] = 0;
                }

                //Bottom
                if (row + 1 < map.length && map[row + 1][col] > currNum) {
                    res[row][col] = 0;
                }

                //Left
                if (col - 1 >= 0 && map[row][col - 1] > currNum) {
                    res[row][col] = 0;
                }

                //Right
                if (col + 1 < map[0].length && map[row][col + 1] > currNum) {
                    res[row][col] = 0;
                }

                //LT Diagonal
                if (row - 1 >= 0 && col - 1 >= 0 && map[row - 1][col - 1] > currNum) {
                    res[row][col] = 0;
                }

                //RT Diagonal
                if (row - 1 >= 0 && col + 1 < map[0].length && map[row - 1][col + 1] > currNum) {
                    res[row][col] = 0;
                }

                //LB Diagonal
                if (row + 1 < map.length && col - 1 >= 0 && map[row + 1][col - 1] > currNum) {
                    res[row][col] = 0;
                }

                //RB Diagonal
                if (row + 1 < map.length && col + 1 < map[0].length && map[row + 1][col + 1] > currNum) {
                    res[row][col] = 0;
                }

            }
        }

        return res;
    }


}
