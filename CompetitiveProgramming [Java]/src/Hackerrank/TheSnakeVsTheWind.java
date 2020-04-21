package Hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-03-24
 */
public class TheSnakeVsTheWind {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char d = in.next().charAt(0);
        int x = in.nextInt();
        int y = in.nextInt();

        int[][] route = findRoute(n, d, new int[]{x, y});
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(route[row][col]);
                if (col + 1 != n) System.out.print(" ");
                else System.out.println();
            }
        }

        in.close();
    }

    static int[][] findRoute(int size, char windDir, int[] pos) {

        int[][] route = new int[size][size];
        boolean[][] visited = new boolean[size][size];

        int count = 0;
        while (count++ < (size * size)) {

            System.out.println(count);
            route[pos[0]][pos[1]] = count;
            visited[pos[0]][pos[1]] = true;
            System.out.println(Arrays.toString(pos));

            boolean found;
            found = moveInSameDirection(windDir, pos, route, visited);
            if (!found) found = moveInLeftPerpendicular(windDir, pos, route, visited);
            if (!found) found = moveInRightPerpendicular(windDir, pos, route, visited);
            if (!found) found = moveInOppositeDirection(windDir, pos, route, visited);

        }

        return route;
    }

    static boolean moveInSameDirection(char windDir, int[] pos, int[][] route, boolean[][] visited) {
        int row = pos[0];
        int col = pos[1];

        if (windDir == 'n' && row - 1 >= 0 && !visited[row - 1][col]) {
            pos[0] = row - 1;
            return true;
        }

        if (windDir == 's' && row + 1 < route.length && !visited[row + 1][col]) {
            pos[0] = row + 1;
            return true;
        }

        if (windDir == 'w' && col - 1 >= 0 && !visited[row][col - 1]) {
            pos[1] = col - 1;
            return true;
        }

        if (windDir == 'e' && col + 1 < route[row].length && !visited[row][col + 1]) {
            pos[1] = col + 1;
            return true;
        }

        return false;
    }

    static boolean moveInLeftPerpendicular(char windDir, int[] pos, int[][] route, boolean[][] visited) {
        int row = pos[0];
        int col = pos[1];

        if (windDir == 'n' && col - 1 >= 0 && !visited[row][col - 1]) {
            pos[1] = col - 1;
            return true;
        }

        if (windDir == 's' && col + 1 < route[row].length && !visited[row][col + 1]) {
            pos[1] = col + 1;
            return true;
        }

        if (windDir == 'e' && row - 1 >= 0 && !visited[row - 1][col]) {
            pos[0] = row - 1;
            return true;
        }

        if (windDir == 'w' && row + 1 < route.length && !visited[row + 1][col]) {
            pos[0] = row + 1;
            return true;
        }

        return false;
    }

    static boolean moveInRightPerpendicular(char windDir, int[] pos, int[][] route, boolean[][] visited) {
        int row = pos[0];
        int col = pos[1];

        if (windDir == 'n' && col + 1 < route[row].length && !visited[row][col + 1]) {
            pos[1] = col + 1;
            return true;
        }

        if (windDir == 's' && col - 1 >= 0 && !visited[row][col - 1]) {
            pos[1] = col - 1;
            return true;
        }

        if (windDir == 'e' && row + 1 < route.length && !visited[row + 1][col]) {
            pos[0] = row + 1;
            return true;
        }

        if (windDir == 'w' && row - 1 >= 0 && !visited[row - 1][col]) {
            pos[0] = row - 1;
            return true;
        }

        return false;
    }

    static boolean moveInOppositeDirection(char windDir, int[] pos, int[][] route, boolean[][] visited) {
        int row = pos[0];
        int col = pos[1];

        if (windDir == 'n' && row + 1 < route.length && !visited[row + 1][col]) {
            pos[0] = row + 1;
            return true;
        }

        if (windDir == 's' && row - 1 >= 0 && !visited[row - 1][col]) {
            pos[0] = row - 1;
            return true;
        }

        if (windDir == 'w' && col + 1 < route[row].length && !visited[row][col + 1]) {
            pos[1] = col + 1;
            return true;
        }

        if (windDir == 'e' && col - 1 >= 0 && !visited[row][col - 1]) {
            pos[1] = col - 1;
            return true;
        }

        return false;
    }
}
