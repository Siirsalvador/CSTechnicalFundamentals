package PhoneScreens.Palantir.FloodMap;

import java.util.Arrays;


class Result {

    static boolean update = true;
    static int idx = 0;

    public static void main(String[] args) {

        int[][] map = {
                {1, 2, 1, 3, 4},
                {1, 5, 2, 2, 2},
                {4, 5, 1, 9, 7},
                {3, 5, 3, 7, 6},
                {4, 3, 1, 7, 3}};

        System.out.println(Arrays.deepToString(findRiskScores(map)));
    }

    public static boolean[][] findHighPoints(int[][] map) {
        // Write your code here

        boolean[][] canReach = new boolean[map.length][map[0].length];
        boolean[][] highPoints = findHighPointsBool(map);

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (map[row][col] >= 1) {
                    findPlateaus(map, canReach, row, col);
                    if (update) updateResultBool(highPoints, canReach);
                    update = true;
                    canReach = new boolean[map.length][map[0].length];
                }

            }
        }

        return highPoints;
    }

    public static boolean[][] findHighPointsBool(int[][] map) {
        boolean[][] res = new boolean[map.length][map[0].length];

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                int currNum = map[row][col];
                res[row][col] = true;

                //Top
                if (row - 1 >= 0 && map[row - 1][col] >= currNum) {
                    res[row][col] = false;
                }

                //Bottom
                if (row + 1 < map.length && map[row + 1][col] >= currNum) {
                    res[row][col] = false;
                }

                //Left
                if (col - 1 >= 0 && map[row][col - 1] >= currNum) {
                    res[row][col] = false;
                }

                //Right
                if (col + 1 < map[0].length && map[row][col + 1] >= currNum) {
                    res[row][col] = false;
                }

                //LT Diagonal
                if (row - 1 >= 0 && col - 1 >= 0 && map[row - 1][col - 1] >= currNum) {
                    res[row][col] = false;
                }

                //RT Diagonal
                if (row - 1 >= 0 && col + 1 < map[0].length && map[row - 1][col + 1] >= currNum) {
                    res[row][col] = false;
                }

                //LB Diagonal
                if (row + 1 < map.length && col - 1 >= 0 && map[row + 1][col - 1] >= currNum) {
                    res[row][col] = false;
                }

                //RB Diagonal
                if (row + 1 < map.length && col + 1 < map[0].length && map[row + 1][col + 1] >= currNum) {
                    res[row][col] = false;
                }

            }
        }

        return res;
    }

    private static void findPlateaus(int[][] map, boolean[][] canReach, int row, int col) {
        if (row < 0 || col < 0 || row >= map.length || col >= map[0].length) return;

        canReach[row][col] = true;

        if (row + 1 < map.length && map[row][col] < map[row + 1][col]) {
            update = false;
        }
        if (row - 1 >= 0 && map[row][col] >= map[row - 1][col]) {
            update = false;
        }
        if (col + 1 < map[0].length && map[row][col] < map[row][col + 1]) {
            update = false;
        }
        if (col - 1 >= 0 && map[row][col] >= map[row][col - 1]) {
            update = false;
        }
        if (row - 1 >= 0 && col - 1 >= 0 && map[row][col] >= map[row - 1][col - 1]) {
            update = false;
        }
        if (row - 1 >= 0 && col + 1 < map[0].length && map[row][col] < map[row - 1][col + 1]) {
            update = false;
        }
        if (row + 1 < map.length && col - 1 >= 0 && map[row][col] < map[row + 1][col - 1]) {
            update = false;
        }
        if (row + 1 < map.length && col + 1 < map[0].length && map[row][col] < map[row + 1][col + 1]) {
            update = false;
        }

        if (row + 1 < map.length && map[row][col] >= map[row + 1][col] && canReach[row + 1][col] == false)
            findPlateaus(map, canReach, row + 1, col);
        if (row - 1 >= 0 && map[row][col] >= map[row - 1][col] && canReach[row - 1][col] == false)
            findPlateaus(map, canReach, row - 1, col);
        if (col + 1 < map[0].length && map[row][col] >= map[row][col + 1] && canReach[row][col + 1] == false)
            findPlateaus(map, canReach, row, col + 1);
        if (col - 1 >= 0 && map[row][col] >= map[row][col - 1] && canReach[row][col - 1] == false)
            findPlateaus(map, canReach, row, col - 1);
        if (row - 1 >= 0 && col - 1 >= 0 && map[row][col] >= map[row - 1][col - 1] && canReach[row - 1][col - 1] == false)
            findPlateaus(map, canReach, row - 1, col - 1);
        if (row - 1 >= 0 && col + 1 < map[0].length && map[row][col] >= map[row - 1][col + 1] && canReach[row - 1][col + 1] == false)
            findPlateaus(map, canReach, row - 1, col + 1);
        if (row + 1 < map.length && col - 1 >= 0 && map[row][col] >= map[row + 1][col - 1] && canReach[row + 1][col - 1] == false)
            findPlateaus(map, canReach, row + 1, col - 1);
        if (row + 1 < map.length && col + 1 < map[0].length && map[row][col] >= map[row + 1][col + 1] && canReach[row + 1][col + 1] == false)
            findPlateaus(map, canReach, row + 1, col + 1);

    }

    private static void updateResultBool(boolean[][] floodRes, boolean[][] canReach) {
        for (int row = 0; row < canReach.length; row++) {
            for (int col = 0; col < canReach[0].length; col++) {
                if (canReach[row][col]) floodRes[row][col] = true;
            }
        }
    }

    public static int[][] findRiskScores(int[][] map) {
        int[][] highPoints = findHighPointsInt(map);
        int[][] floodRes = new int[map.length][map[0].length];

        boolean[][] canReach = new boolean[map.length][map[0].length];

        for (int row = 0; row < highPoints.length; row++) {
            for (int col = 0; col < highPoints[0].length; col++) {
                if (highPoints[row][col] == 1) {
                    dfs(map, canReach, row, col);
                    updateResultInt(floodRes, canReach);
                    canReach = new boolean[map.length][map[0].length];
                }

            }
        }

        return floodRes;
    }

    private static int[][] findHighPointsInt(int[][] map) {
        int[][] res = new int[map.length][map[0].length];

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                int currNum = map[row][col];
                res[row][col] = 1;

                //Top
                if (row - 1 >= 0 && map[row - 1][col] >= currNum) {
                    res[row][col] = 0;
                }

                //Bottom
                if (row + 1 < map.length && map[row + 1][col] >= currNum) {
                    res[row][col] = 0;
                }

                //Left
                if (col - 1 >= 0 && map[row][col - 1] >= currNum) {
                    res[row][col] = 0;
                }

                //Right
                if (col + 1 < map[0].length && map[row][col + 1] >= currNum) {
                    res[row][col] = 0;
                }

                //LT Diagonal
                if (row - 1 >= 0 && col - 1 >= 0 && map[row - 1][col - 1] >= currNum) {
                    res[row][col] = 0;
                }

                //RT Diagonal
                if (row - 1 >= 0 && col + 1 < map[0].length && map[row - 1][col + 1] >= currNum) {
                    res[row][col] = 0;
                }

                //LB Diagonal
                if (row + 1 < map.length && col - 1 >= 0 && map[row + 1][col - 1] >= currNum) {
                    res[row][col] = 0;
                }

                //RB Diagonal
                if (row + 1 < map.length && col + 1 < map[0].length && map[row + 1][col + 1] >= currNum) {
                    res[row][col] = 0;
                }

            }
        }

        return res;
    }

    private static void updateResultInt(int[][] floodRes, boolean[][] canReach) {
        for (int row = 0; row < canReach.length; row++) {
            for (int col = 0; col < canReach[0].length; col++) {
                if (canReach[row][col]) floodRes[row][col] += 1;
            }
        }
    }

    public static void dfs(int[][] matrix, boolean[][] canReach, int row, int col) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) return;
        canReach[row][col] = true;
        if (row + 1 < matrix.length && matrix[row][col] > matrix[row + 1][col] && canReach[row + 1][col] == false)
            dfs(matrix, canReach, row + 1, col);
        if (row - 1 >= 0 && matrix[row][col] > matrix[row - 1][col] && canReach[row - 1][col] == false)
            dfs(matrix, canReach, row - 1, col);
        if (col + 1 < matrix[0].length && matrix[row][col] > matrix[row][col + 1] && canReach[row][col + 1] == false)
            dfs(matrix, canReach, row, col + 1);
        if (col - 1 >= 0 && matrix[row][col] > matrix[row][col - 1] && canReach[row][col - 1] == false)
            dfs(matrix, canReach, row, col - 1);
        if (row - 1 >= 0 && col - 1 >= 0 && matrix[row][col] > matrix[row - 1][col - 1] && canReach[row - 1][col - 1] == false)
            dfs(matrix, canReach, row - 1, col - 1);
        if (row - 1 >= 0 && col + 1 < matrix[0].length && matrix[row][col] > matrix[row - 1][col + 1] && canReach[row - 1][col + 1] == false)
            dfs(matrix, canReach, row - 1, col + 1);
        if (row + 1 < matrix.length && col - 1 >= 0 && matrix[row][col] > matrix[row + 1][col - 1] && canReach[row + 1][col - 1] == false)
            dfs(matrix, canReach, row + 1, col - 1);
        if (row + 1 < matrix.length && col + 1 < matrix[0].length && matrix[row][col] > matrix[row + 1][col + 1] && canReach[row + 1][col + 1] == false)
            dfs(matrix, canReach, row + 1, col + 1);

    }

    /*
    * Find Highpoints. Update result matrix.
    *
    * Find plateaus. How?. Temp Matrix whose values are reflected result matrix if none of it's elements break the rule.
    * Have a visited matrix as well.
    *
    * Return result.
    * */


}
