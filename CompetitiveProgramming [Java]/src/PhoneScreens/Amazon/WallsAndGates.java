package PhoneScreens.Amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-05
 */
public class WallsAndGates {

    public static void main(String[] args) {
        int[][] rooms = {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };

        wallsAndGates(rooms);
        System.out.println(Arrays.deepToString(rooms));
    }

    public static void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0)
            return;

        Queue<int[]> nodes = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) nodes.add(new int[]{i, j, 0});
            }
        }

        while (!nodes.isEmpty()) {
            int[] currNode = nodes.poll();
            visitAndUpdateAdjacentNodes(currNode, rooms, nodes);
        }
    }

    //Approach 1
    private static void visitAndUpdateAdjacentNodes(int[] currNode, int[][] rooms, Queue<int[]> nodes) {
        int row = currNode[0];
        int col = currNode[1];
        int dist = currNode[2] + 1;

        if (row - 1 >= 0 && rooms[row - 1][col] != -1 && dist < rooms[row - 1][col]) {
            rooms[row - 1][col] = dist;
            nodes.add(new int[]{row - 1, col, dist});
        }

        if (row + 1 < rooms.length && rooms[row + 1][col] != -1 && dist < rooms[row + 1][col]) {
            rooms[row + 1][col] = dist;
            nodes.add(new int[]{row + 1, col, dist});
        }

        if (col - 1 >= 0 && rooms[row][col - 1] != -1 && dist < rooms[row][col - 1]) {
            rooms[row][col - 1] = dist;
            nodes.add(new int[]{row, col - 1, dist});
        }

        if (col + 1 < rooms[0].length && rooms[row][col + 1] != -1 && dist < rooms[row][col + 1]) {
            rooms[row][col + 1] = dist;
            nodes.add(new int[]{row, col + 1, dist});
        }
    }

    //Approach 2
    private void visitAndUpdateAdjacentNodes2(int[] currNode, int[][] rooms, Queue<int[]> nodes) {
        int row = currNode[0];
        int col = currNode[1];
        int dist = rooms[row][col] + 1;

        if (row - 1 >= 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
            rooms[row - 1][col] = dist;
            nodes.add(new int[]{row - 1, col});
        }

        if (row + 1 < rooms.length && rooms[row + 1][col] == Integer.MAX_VALUE) {
            rooms[row + 1][col] = dist;
            nodes.add(new int[]{row + 1, col});
        }

        if (col - 1 >= 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
            rooms[row][col - 1] = dist;
            nodes.add(new int[]{row, col - 1});
        }

        if (col + 1 < rooms[0].length && rooms[row][col + 1] == Integer.MAX_VALUE) {
            rooms[row][col + 1] = dist;
            nodes.add(new int[]{row, col + 1});
        }
    }
}
