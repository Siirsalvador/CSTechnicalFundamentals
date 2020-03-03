package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-24
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        //for each point that is 1, find all connected points (dfs)
        //mark each point as visited
        //increment count when you can enter the if statement
        //return count at the end
        int islands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    dfs(row, col, grid);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(int row, int col, char[][] grid) {
        if (grid == null || row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1')
            return;

        grid[row][col] = '-';
        //Top
        dfs(row - 1, col, grid);

        //Bottom
        dfs(row + 1, col, grid);

        //Left
        dfs(row, col - 1, grid);

        //Right
        dfs(row, col + 1, grid);
    }
}
