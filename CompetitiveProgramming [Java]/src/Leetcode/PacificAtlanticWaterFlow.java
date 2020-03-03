package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-21
 */
public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        System.out.println(pacificAtlantic(matrix));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // Graph
        //1, From pacific borders, which points can be reached
        //2. From atlantic borders, which points can be reached
        //3. if one point can be reached from both pacific and atlantic, it is the result

        // Edge case
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return new ArrayList<>();

        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] canReachPacific = new boolean[rows][cols];
        boolean[][] canReachAtlantic = new boolean[rows][cols];
        // start from pacific: top
        for (int i = 0; i < cols; i++)
            dfs(matrix, canReachPacific, 0, i);
        // start from pacific : left
        for (int j = 0; j < rows; j++)
            dfs(matrix, canReachPacific, j, 0);
        // start from atlantic: right
        for (int i = 0; i < rows; i++)
            dfs(matrix, canReachAtlantic, i, cols - 1);
        System.out.println(Arrays.deepToString(canReachAtlantic));
        // start from atlantic: bottom
        for (int j = 0; j < cols; j++)
            dfs(matrix, canReachAtlantic, rows - 1, j);

//        System.out.println(Arrays.deepToString(canReachAtlantic));
//        System.out.println(Arrays.deepToString(canReachPacific));

        // if point can reach both pacific and atlantic, then it is correct
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }

        return res;
    }

    public static void dfs(int[][] matrix, boolean[][] canReach, int row, int col) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) return;
        canReach[row][col] = true;
        if (row + 1 < matrix.length && matrix[row][col] <= matrix[row + 1][col] && canReach[row + 1][col] == false)
            dfs(matrix, canReach, row + 1, col);
        if (row - 1 >= 0 && matrix[row][col] <= matrix[row - 1][col] && canReach[row - 1][col] == false)
            dfs(matrix, canReach, row - 1, col);
        if (col + 1 < matrix[0].length && matrix[row][col] <= matrix[row][col + 1] && canReach[row][col + 1] == false)
            dfs(matrix, canReach, row, col + 1);
        if (col - 1 >= 0 && matrix[row][col] <= matrix[row][col - 1] && canReach[row][col - 1] == false)
            dfs(matrix, canReach, row, col - 1);
    }
}
