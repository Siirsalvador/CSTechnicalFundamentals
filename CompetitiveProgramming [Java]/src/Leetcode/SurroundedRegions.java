package Leetcode;

import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-21
 */
public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] board = {
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}
        };

        solve(board);
        System.out.println(Arrays.deepToString(board));
        /*

        [
        ["O","X","X","O","X"],
        ["X","X","X","X","O"],
        ["X","X","X","O","X"],
        ["O","X","O","O","O"],
        ["X","X","O","X","O"]]
        * */
    }

    public static void solve(char[][] board) {

        for (int row = 1; row < board.length - 1; row++) {
            for (int col = 1; col < board[0].length - 1; col++) {
                if (legalSurrounding(row, col, board) && board[row][col] == 'O') {
                    dfs(row, col, board);
                }
            }
        }

    }

    private static boolean legalSurrounding(int row, int col, char[][] board) {

        if (row - 1 == 0 && board[row - 1][col] == 'O') {
            return false;
        }

        if (row + 1 == board.length - 1 && board[row + 1][col] == 'O') {
            return false;
        }

        if (col - 1 == 0 && board[row][col - 1] == 'O') {
            return false;
        }

        if (col + 1 == board.length - 1 && board[row][col + 1] == 'O') {
            return false;
        }

        return legalSurrounding(row - 1, col, board) ||
                legalSurrounding(row + 1, col, board) ||
                legalSurrounding(row, col - 1, board) ||
                legalSurrounding(row, col + 1, board);
    }


    private static void dfs(int row, int col, char[][] board) {
        if (row < 1 || col < 1 || row >= board.length - 1 || col >= board[0].length) return;

        if (legalSurrounding(row, col, board) && board[row][col] == 'O') {

            board[row][col] = 'X';

            //Top
            dfs(row - 1, col, board);

            //Bottom
            dfs(row + 1, col, board);

            //Left
            dfs(row, col - 1, board);

            //Right
            dfs(row, col + 1, board);
        }

    }

}
