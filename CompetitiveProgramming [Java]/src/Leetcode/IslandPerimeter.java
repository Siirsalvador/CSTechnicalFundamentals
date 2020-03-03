package Leetcode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-20
 */
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    if (row - 1 < 0 || grid[row - 1][col] == 0) perimeter++;
                    if (row + 1 >= grid.length || grid[row + 1][col] == 0) perimeter++;
                    if (col - 1 < 0 || grid[row][col - 1] == 0) perimeter++;
                    if (col + 1 >= grid[0].length || grid[row][col + 1] == 0) perimeter++;
                }
            }
        }
        return perimeter;
    }
}
