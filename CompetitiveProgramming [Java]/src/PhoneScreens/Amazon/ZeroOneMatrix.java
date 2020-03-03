package PhoneScreens.Amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-14
 */

// 01Matrix
public class ZeroOneMatrix {

    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0][0];

        Queue<int[]> cells = new LinkedList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0) cells.offer(new int[]{i, j, 0});
            }
        }

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        while(!cells.isEmpty()){
            int[] curr = cells.poll();
            int row = curr[0];
            int col = curr[1];
            int lvl = curr[2];

            if(matrix[row][col] != 0){
                matrix[row][col] = lvl;
            }

            if(row - 1 >=0 && matrix[row - 1][col] != 0 && !visited[row - 1][col]){
                cells.offer(new int[]{row - 1, col, lvl + 1});
                visited[row - 1][col] = true;
            }

            if(row + 1 < matrix.length && matrix[row + 1][col] != 0 && !visited[row + 1][col]){
                cells.offer(new int[]{row + 1, col, lvl + 1});
                visited[row + 1][col] = true;
            }

            if(col - 1 >=0 && matrix[row][col - 1] != 0 && !visited[row][col - 1]){
                cells.offer(new int[]{row, col - 1, lvl + 1});
                visited[row][col - 1] = true;
            }

            if(col + 1 < matrix[row].length && matrix[row][col + 1] != 0 && !visited[row][col + 1]){
                cells.offer(new int[]{row, col + 1, lvl + 1});
                visited[row][col + 1] = true;
            }
        }


        return matrix;
    }
}
