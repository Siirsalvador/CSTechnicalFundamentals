package Hackerrank;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-04-02
 */
public class BobsGame2 {
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
            System.out.println("<------------------------------------->");
            System.out.println(playGame(gameBoard));
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

    private static String playGame(int[][] gameBoard) {

        Set<String> triedMoves = new HashSet<>(); //Come back to check efficacy
        Set<String> playerKingPos = new HashSet<>();
        Set<String> unmovedKings = new HashSet<>();

        int wins = 0;
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[row].length; col++) {
                if (gameBoard[row][col] == 1) {
                    List<int[]> moves = getValidMoves(row, col, gameBoard);

                    for (int[] move : moves) {
                        gameBoard[row][col]--;
                        gameBoard[move[0]][move[1]]++;
                        String key = "Bob" + ":" + move[0] + ":" + move[1];
                        if (!triedMoves.contains(key) && moveCanWinGame("Bob", move[0], move[1], gameBoard, key)) {
                            System.out.println("Row: " + row + "& Col: " + col);
                            System.out.println("Move Row: " + move[0] + "& Move Col: " + move[1]);
                            System.out.println("-------------------------------------");
                            wins++;
                        }

                        triedMoves.add(key);
                        gameBoard[row][col]++;
                        gameBoard[move[0]][move[1]]--;
                    }

                }
            }
        }

        return wins > 0 ? "WIN " + wins : "LOSE";
    }

    private static boolean moveCanWinGame(String player, int row, int col, int[][] gameBoard, String path) {
        if (row < 0 || row >= gameBoard.length || col < 0 || col >= gameBoard[row].length || gameBoard[row][col] == -1)
            return false;

        List<int[]> moves = getValidMoves(row, col, gameBoard);

        if (moves.size() == 0 && player.equals("Bob")) {
            System.out.println(Arrays.deepToString(gameBoard));
            System.out.println(path);
            return true;
        }

        if (moves.size() == 0)
            return false;

        player = player.equals("Bob") ? "Alice" : "Bob";

        boolean found = false;
        for (int[] move : moves) {
            String key = player + ":" + move[0] + ":" + move[1];

            gameBoard[row][col]--;
            gameBoard[move[0]][move[1]]++;

            found = moveCanWinGame(player, move[0], move[1], gameBoard, path + "; " + key);
            if (found) return true;

            gameBoard[row][col]++;
            gameBoard[move[0]][move[1]]--;
        }

        return false;
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
