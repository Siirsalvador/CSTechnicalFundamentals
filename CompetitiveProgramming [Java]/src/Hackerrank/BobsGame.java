package Hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-03-26
 */
public class BobsGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            String[][] board = new String[n][n];
            for (int board_i = 0; board_i < n; board_i++) {
                board[board_i] = in.next().split("");
            }

            int[][] gameBoard = generateGameBoard(board);
            System.out.println(Arrays.deepToString(gameBoard));
            //System.out.println(playGame(gameBoard));
        }
        in.close();
    }

    private static int[][] generateGameBoard(String[][] board) {
        int[][] gameBoard = new int[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col].equals("K")) gameBoard[row][col]++;
                else if (board[row][col].equals("X")) gameBoard[row][col] = -1;
            }
        }
        return gameBoard;
    }

    private static String playGame(int[][] board) {
        int[] winCnt = new int[1];

        moveKing("Bob", board, winCnt);
        return winCnt[0] == 0 ? "LOSE" : "WIN " + winCnt[0];
    }

    private static void moveKing(String player, int[][] board, int[] winCnt) {

        String nxtPlayer = player.equals("Bob") ? "Alice" : "Bob";

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {

                if (board[row][col] > 0) {
                    List<int[]> moves = getValidMoves(row, col, board);
                    if (moves.size() == 0 && player.equals("Alice"))
                        winCnt[0]++;

                    for (int[] move : moves) {
                        board[row][col]--;
                        board[move[0]][move[1]]++;

                        moveKing(nxtPlayer, board, winCnt);

                        board[row][col]++;
                        board[move[0]][move[1]]--;
                    }
                }

            }
        }

    }

    private static List<int[]> getValidMoves(int row, int col, int[][] board) {

        List<int[]> moves = new ArrayList<>();

        //Top
        if (row - 1 >= 0 && board[row - 1][col] != -1) {
            moves.add(new int[]{row - 1, col});
        }

        //Left
        if (col - 1 >= 0 && board[row][col - 1] != -1) {
            moves.add(new int[]{row, col - 1});
        }

        //Top Left
        if (col - 1 >= 0 && row - 1 >= 0 && board[row - 1][col - 1] != -1) {
            moves.add(new int[]{row - 1, col - 1});
        }

        return moves;
    }
}
