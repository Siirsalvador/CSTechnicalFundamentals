package Firecode;

import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-20
 */
public class MatrixMaxSumPathDFS {

    public static int matrixMaxSumDfs(int[][] grid) {
        if (grid == null) return 0;
        if (grid.length == 1 && grid[0].length == 1) {
            return grid[0][0];
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int max = Integer.MIN_VALUE;

        Stack<GridNode> nodes = new Stack<>();
        nodes.add(new GridNode(0, 0, grid[0][0]));

        while (!nodes.isEmpty()) {
            GridNode curr = nodes.pop();

            if (curr.row + 1 == rows && curr.col + 1 == cols) {
                max = Math.max(max, curr.sum);
                continue;
            }

            if (curr.row + 1 != rows) {
                nodes.add(new GridNode(curr.row + 1, curr.col, curr.sum + grid[curr.row + 1][curr.col]));
            }

            if (curr.col + 1 != cols) {
                nodes.add(new GridNode(curr.row, curr.col + 1, curr.sum + grid[curr.row][curr.col + 1]));
            }

        }

        return max;
    }

    static class GridNode {
        int row;
        int col;
        int sum;

        GridNode(int row, int col, int sum) {
            this.row = row;
            this.col = col;
            this.sum = sum;
        }
    }
}
