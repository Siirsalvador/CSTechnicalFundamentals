package PhoneScreens.Amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-07
 */
public class OnlineTestMinHours {

    public static void main(String[] args){

        List<List<Integer>> grid = new ArrayList<>();
        grid.add(0, new ArrayList<>());
        grid.add(1, new ArrayList<>());
        grid.add(2, new ArrayList<>());
        grid.add(3, new ArrayList<>());

        grid.get(0).add(0);
        grid.get(0).add(1);
        grid.get(0).add(1);
        grid.get(0).add(0);
        grid.get(0).add(1);

        grid.get(1).add(0,0);
        grid.get(1).add(1,1);
        grid.get(1).add(2,0);
        grid.get(1).add(3,1);
        grid.get(1).add(4,0);

        grid.get(2).add(0,0);
        grid.get(2).add(1,0);
        grid.get(2).add(2,0);
        grid.get(2).add(3,0);
        grid.get(2).add(4,1);

        grid.get(3).add(0,0);
        grid.get(3).add(1,1);
        grid.get(3).add(2,0);
        grid.get(3).add(3,0);
        grid.get(3).add(4,0);

        System.out.println(minimumHours(4, 5, grid));
    }

    static int minimumHours(int rows, int columns, List<List<Integer>> grid) {
        // WRITE YOUR CODE HERE

        if (rows < 1 || columns < 1 || grid.size() == 0 || grid.get(0).size() == 0) return 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }

        int maxHours = 0;
        while (!queue.isEmpty()) {
            int[] currCell = queue.poll();
            int row = currCell[0];
            int col = currCell[1];
            int hours = currCell[2] + 1;

            if (row - 1 >= 0 && grid.get(row - 1).get(col) == 0) {
                grid.get(row - 1).set(col, 1);
                queue.offer(new int[]{row - 1, col, hours});
            }

            if (row + 1 < grid.size() && grid.get(row + 1).get(col) == 0) {
                grid.get(row + 1).set(col, 1);
                queue.offer(new int[]{row + 1, col, hours});
            }

            if (col - 1 >= 0 && grid.get(row).get(col - 1) == 0) {
                grid.get(row).set(col - 1, 1);
                queue.offer(new int[]{row, col - 1, hours});
            }

            if (col + 1 < grid.get(row).size() && grid.get(row).get(col + 1) == 0) {
                grid.get(row).set(col + 1, 1);
                queue.offer(new int[]{row, col + 1, hours});
            }

            maxHours = Math.max(maxHours, hours);
        }

        return maxHours;
    }
}
