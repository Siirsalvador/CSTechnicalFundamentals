package PhoneScreens.Amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-05
 */
public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}};

        int[][] grid2 = {
                {0, 1}};
        /*
            {2, 2, 1},
            {2, 1, 0},
            {0, 1, 1}}
         */

        System.out.println(orangesRotting2(grid));
    }

    public static int orangesRotting(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int[][] prev = new int[grid.length][grid[0].length];
        int count = -1;

        boolean diff = true;
        while (diff) { //N * MINS + 1

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    prev[i][j] = grid[i][j];
                }
            }

            for (int i = 0; i < prev.length; i++) {
                for (int j = 0; j < prev[0].length; j++) {
                    if (prev[i][j] == 2) updateRottenOranges(i, j, grid, prev);
                }
            }

            count++;
            diff = !Arrays.deepEquals(prev, grid);

        }

        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 1) return -1;
            }
        }

        return count;
    }

    private static void updateRottenOranges(int row, int col, int[][] grid, int[][] prev) {
        if (row - 1 >= 0 && grid[row - 1][col] == 1) grid[row - 1][col] = 2;
        if (row + 1 < grid.length && grid[row + 1][col] == 1) grid[row + 1][col] = 2;
        if (col - 1 >= 0 && grid[row][col - 1] == 1) grid[row][col - 1] = 2;
        if (col + 1 < grid[0].length && grid[row][col + 1] == 1) grid[row][col + 1] = 2;
    }

    public static int orangesRotting2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        Queue<int[]> nodes = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    nodes.add(new int[]{i, j, 0});
                }
            }
        }

        int maxMin = 0;
        while (!nodes.isEmpty()) {
            int[] currNode = nodes.poll();
            int row = currNode[0];
            int col = currNode[1];
            int currMin = currNode[2];

            visitAndUpdateAdjacents(row, col, currMin, grid, nodes);
            maxMin = Math.max(maxMin, currMin);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return maxMin;
    }

    private static void visitAndUpdateAdjacents(int row, int col, int currMin, int[][] grid, Queue<int[]> nodes) {
        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
            grid[row - 1][col] = 2;
            nodes.add(new int[]{row - 1, col, currMin + 1});
        }

        if (row + 1 < grid.length && grid[row + 1][col] == 1) {
            grid[row + 1][col] = 2;
            nodes.add(new int[]{row + 1, col, currMin + 1});
        }

        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
            grid[row][col - 1] = 2;
            nodes.add(new int[]{row, col - 1, currMin + 1});
        }

        if (col + 1 < grid[0].length && grid[row][col + 1] == 1) {
            grid[row][col + 1] = 2;
            nodes.add(new int[]{row, col + 1, currMin + 1});
        }
    }

}
