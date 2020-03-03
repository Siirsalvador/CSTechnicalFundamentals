package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-21
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        //Keep a set of visited points
        //Visit each point, for each point visit each connecting point as long as it is 1 && not the limit
        //Everytime we find a point not in visited points, we update island no

        Set<String> visitedPoints = new HashSet<>();
        int islands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                String key = row + "." + col;
                if (!visitedPoints.contains(key) && grid[row][col] == '1') {
                    visitAdjacentNodes(row, col, grid, visitedPoints);
                    islands++;
                }
            }
        }

        return islands;
    }

    public static void visitAdjacentNodes(int row, int col, char[][] grid, Set<String> visitedPoints) {

        String key = row + "." + col;

        if (!visitedPoints.contains(key) && grid[row][col] == '1') {

            visitedPoints.add(key);

            //Top
            if (row - 1 >= 0) {
                visitAdjacentNodes(row - 1, col, grid, visitedPoints);
            }

            //Bottom
            if (row + 1 < grid.length) {
                visitAdjacentNodes(row + 1, col, grid, visitedPoints);
            }

            //Left
            if (col - 1 >= 0) {
                visitAdjacentNodes(row, col - 1, grid, visitedPoints);
            }

            //Right
            if (col + 1 < grid[0].length) {
                visitAdjacentNodes(row, col + 1, grid, visitedPoints);
            }
        }
    }

}
