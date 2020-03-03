package ChiPractice;

import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-01
 */
public class PalantirPractice {
    static public void main(String args[]) {
        System.out.println("Practice makes Perfect!");
        int[][] input = new int[][]{{1, 2, 1, 3, 4},
                {1, 5, 2, 2, 2},
                {4, 5, 1, 9, 7},
                {3, 5, 3, 7, 6},
                {4, 3, 1, 7, 3}};
        System.out.println(Arrays.deepToString(findHighPointsBool(input)));
        System.out.println(Arrays.deepToString(findRiskScores(input)));

        input = new int[][]{
                {1, 2, 3, 4},
                {5, 5, 5, 2},
                {5, 1, 1, 1},
                {0, 0, 0, 9}};
        System.out.println(Arrays.deepToString(findPlateaus(input)));
    }


    //Question 1 Find Highpoints. Print out as bool.
    /*
                {1, 2, 1, 3, 4},
                {1, 5, 2, 2, 2},
                {4, 5, 1, 9, 7},
                {3, 5, 3, 7, 6},
                {4, 3, 1, 7, 3}

                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}}
    */
    public static boolean[][] findHighPointsBool(int[][] map) {

        // null && empty check

        boolean[][] res = new boolean[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                res[i][j] = check(i, j, map);
            }
        }

        return res;
    }

    private static boolean check(int i, int j, int[][] map) {

        boolean high;
        int val = map[i][j];
        int rows = map.length;
        int cols = map[i].length;

        high = i == 0 || j == 0 || (map[i - 1][j - 1] < val);//upward left
        high &= i == 0 || map[i - 1][j] < val;//up
        high &= i == 0 || j == cols - 1 || map[i - 1][j + 1] < val; //upward right
        high &= j == 0 || map[i][j - 1] < val; //left
        high &= j == cols - 1 || map[i][j + 1] < val; //right
        high &= i == rows - 1 || j == 0 || map[i + 1][j - 1] < val; //downward left
        high &= i == rows - 1 || map[i + 1][j] < val; //down
        high &= i == rows - 1 || j == cols - 1 || map[i + 1][j + 1] < val; //downward right

        return high;
    }


    //Question 2 Find RiskScores. The idea is to find every cell that a highpoint can reach (using a condition)
    //and incrementing that cell by 1. So it means if 2 highpoints can reach a cell, that cell's risk score is 2.
    /*
                {1, 2, 1, 3, 4},
                {1, 5, 2, 2, 2},
                {4, 5, 1, 9, 7},
                {3, 5, 3, 7, 6},
                {4, 3, 1, 7, 3}

                {0, 0, 0, 0, 1}, 0, 4
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}

                >
                {0, 0, 1, 1, 1}, 4
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}


                [0, 0, 2, 1, 1],
                [0, 0, 2, 2, 2],
                [0, 0, 2, 1, 1],
                [0, 0, 1, 1, 1],
                [0, 0, 1, 0, 1]]
    */
    public static int[][] findRiskScores(int[][] map) {

        boolean[][] highs = findHighPointsBool(map);
        int[][] res = new int[map.length][map[0].length];

        int[][] temp;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (highs[i][j]) {
                    temp = new int[map.length][map[0].length];
                    findRisk(i, j, map[i][j] + 1, map, temp);
                    temp[i][j] = 1;
                    updateRes(res, temp);
                }
            }
        }

        return res;
    }

    private static void updateRes(int[][] res, int[][] temp) {
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] += temp[i][j];
            }
        }
    }

    private static void findRisk(int i, int j, int target, int[][] map, int[][] res) {

        if (i < 0 || i >= map.length || j < 0 || j >= map[i].length || res[i][j] > 0) {
            return;
        }

        int val = map[i][j];
        if (val >= target) {
            return;
        }

        res[i][j] = 1;

        findRisk(i - 1, j - 1, val, map, res);
        findRisk(i - 1, j, val, map, res);
        findRisk(i - 1, j + 1, val, map, res);
        findRisk(i, j - 1, val, map, res);
        findRisk(i, j + 1, val, map, res);
        findRisk(i + 1, j - 1, val, map, res);
        findRisk(i + 1, j, val, map, res);
        findRisk(i + 1, j + 1, val, map, res);
    }


    //Question 3 Find Plateaus. Print out as bool.
    /*
                <=
                1 2 3 4    0 0 0 0
                5 5 4 2    1 1 0 0
                5 1 1 8 -> 0 0 0 0
                0 0 0 9    0 0 0 0

    */

    public static boolean[][] findPlateaus(int[][] map) {

        boolean[][] isHigh = new boolean[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                isHigh[i][j] = check2(i, j, map);
            }
        }

        boolean[][] res = new boolean[map.length][map[0].length];
        boolean[][] visiting = new boolean[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (isHigh[i][j]) {
                    res[i][j] = plateauCheck(i, j, map[i][j], map, isHigh, visiting);
                }
            }
        }

        return res;
    }

    private static boolean plateauCheck(int i, int j, int target, int[][] map, boolean[][] isHigh, boolean[][] visiting) {

        if (i < 0 || i >= map.length || j < 0 || j >= map[i].length || map[i][j] < target || visiting[i][j]) {
            return true;
        }

        int val = map[i][j];
        if (val == target && !isHigh[i][j]) {
            return false;
        }

        visiting[i][j] = true;
        boolean valid = plateauCheck(i - 1, j - 1, val, map, isHigh, visiting);
        valid &= plateauCheck(i - 1, j, val, map, isHigh, visiting);
        valid &= plateauCheck(i - 1, j + 1, val, map, isHigh, visiting);
        valid &= plateauCheck(i, j - 1, val, map, isHigh, visiting);
        valid &= plateauCheck(i, j + 1, val, map, isHigh, visiting);
        valid &= plateauCheck(i + 1, j - 1, val, map, isHigh, visiting);
        valid &= plateauCheck(i + 1, j, val, map, isHigh, visiting);
        valid &= plateauCheck(i + 1, j + 1, val, map, isHigh, visiting);

        visiting[i][j] = false;
        return valid;
    }

    private static boolean check2(int i, int j, int[][] map) {

        boolean high;
        int val = map[i][j];
        int rows = map.length;
        int cols = map[i].length;

        high = i == 0 || j == 0 || (map[i - 1][j - 1] <= val);//upward left
        high &= i == 0 || map[i - 1][j] <= val;//up
        high &= i == 0 || j == cols - 1 || map[i - 1][j + 1] <= val; //upward right
        high &= j == 0 || map[i][j - 1] <= val; //left
        high &= j == cols - 1 || map[i][j + 1] <= val; //right
        high &= i == rows - 1 || j == 0 || map[i + 1][j - 1] <= val; //downward left
        high &= i == rows - 1 || map[i + 1][j] <= val; //down
        high &= i == rows - 1 || j == cols - 1 || map[i + 1][j + 1] <= val; //downward right

        return high;
    }
}