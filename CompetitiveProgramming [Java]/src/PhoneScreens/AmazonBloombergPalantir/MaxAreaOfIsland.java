package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-25
 */
public class MaxAreaOfIsland {

    public static void main(String[] a) {
        int[][] m = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};

        System.out.println(maxAreaOfIsland(m));
    }

    public static int maxAreaOfIsland(int[][] grid) {

        int[] a = new int[1];
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, a);
                    area = Math.max(a[0], area);
                    a = new int[1];
                }
            }
        }

        return area;
    }

    public static void dfs(int[][] grid, int row, int col, int[] store) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return;

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1)
            return;

        grid[row][col] = 0;
        store[0]++;

        //Top
        dfs(grid, row - 1, col, store);
        //Bottom
        dfs(grid, row + 1, col, store);
        //Left
        dfs(grid, row, col - 1, store);
        //Right
        dfs(grid, row, col + 1, store);
    }
}
