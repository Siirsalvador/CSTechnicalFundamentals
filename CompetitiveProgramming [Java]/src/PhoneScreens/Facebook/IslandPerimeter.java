package PhoneScreens.Facebook;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-30
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int currPer = getPerimeter(i, j, grid);
                    perimeter += currPer;
                }
            }
        }

        return perimeter;
    }

    private int getPerimeter(int row, int col, int[][] grid) {
        int currPerimeter = 4;
        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
            currPerimeter--;
        }

        if (row + 1 < grid.length && grid[row + 1][col] == 1) {
            currPerimeter--;
        }

        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
            currPerimeter--;
        }

        if (col + 1 < grid[row].length && grid[row][col + 1] == 1) {
            currPerimeter--;
        }

        return currPerimeter;
    }
}
