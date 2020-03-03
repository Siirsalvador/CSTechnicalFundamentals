package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-20
 */
public class MatrixMaxSumPathDP {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 3, 4, 5, 6, 7}
        };

        System.out.println(matrixMaxSumDP(grid));
    }

    public static int matrixMaxSumDP(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];

        return helper(grid, 0, 0, dp);
    }

    public static int helper(int[][] grid, int row, int col, int[][] dp) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }

        if(row == grid.length || col == grid[0].length){
            return Integer.MIN_VALUE;
        }

        if (dp[row][col] == 0) {
            int right = helper(grid, row, col + 1, dp);
            int down = helper(grid, row + 1, col, dp);
            int maxPath = grid[row][col] + Math.max(right, down);
            dp[row][col] = maxPath;
        }

        return dp[row][col];
    }
}
