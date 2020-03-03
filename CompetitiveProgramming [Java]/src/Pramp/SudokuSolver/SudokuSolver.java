package Pramp.SudokuSolver;

import java.util.ArrayList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-27
 */

/*

 */
public class SudokuSolver {

    static boolean sudokuSolve(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;
        /*
            For each empty cell, consider 'newCandidates', the
            set of possible candidate values that can
            be placed into that cell.
         */
        int row = -1;
        int col = -1;
        ArrayList<Character> candidates = new ArrayList<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {

                if (board[r][c] == '.') {
                    ArrayList<Character> newCandidates = getCandidate(board, r, c);

                    /*
                        Then, we want to keep the smallest
                        sized 'newCandidates', plus remember the
                        position where it was found
                     */
                    if (candidates.size() == 0 || newCandidates.size() < candidates.size()) {
                        candidates = newCandidates;
                        row = r;
                        col = c;
                    }
                }
            }
        }

        /*
            If we have not found any empty cell, then
            the whole board is filled already
         */
        if (candidates.size() == 0 && board[row][col] != '.') {
            return false;
        }

        if (row == -1 && col == -1) return true;

        /*
            For each possible value that can be placed
            in position (row, col), let's
            place that value and then recursively query
            whether the board can be solved.  If it can, we are done.
         */
        for (Character val : candidates) {
            board[row][col] = val;
            if (sudokuSolve(board))
                return true;
            /*
                The tried value val didn't work so restore
                the (row, col) cell back to '.'
             */
            board[row][col] = '.';

        }

        /*
            Otherwise, there is no value that can be placed
            into position (row, col) to make the
            board solved
         */
        return false;
    }

    private static ArrayList<Character> getCandidate(char[][] board, int row, int col) {

        /*
            For some empty cell board[row][col], what possible
            characters can be placed into this cell
            that aren't already placed in the same row,
            column, and sub-board?

            At the beginning, we don't have any candidates
         */
        ArrayList<Character> candidates = new ArrayList<>();

        /*
            For each character add it to the candidate list
            only if there's no collision, i.e. that character
            doesn't already exist in the same row, column
            and sub-board. Notice the top-left corner of (row, col)'s
            sub-board is (row - row%3, col - col%3).
         */
        for (char chr = '1'; chr <= '9'; chr++) {
            boolean collision = false;
            for (int pos = 0; pos < board.length; pos++) {
                if (board[row][pos] == chr ||
                        board[pos][col] == chr ||
                        board[(int) ((row - row % 3) + Math.floor(pos / 3))][(col - col % 3) + pos % 3] == chr) {
                    collision = true;
                    break;
                }
            }

            if (!collision)
                candidates.add(chr);
        }

        return candidates;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'.', '2', '3', '4', '5', '6', '7', '8', '9'},
                {'1', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};

        System.out.println(sudokuSolve(board));

    }

    /*
    function getCandidates(board, row, col):
      # What values can be placed in empty cell board[row][col] ?

    function sudokuSolve(board):
      # For each empty cell (row, col):
      #   If (row, col) has fewer candidate values that can be placed
      #   in board[row][col]than we've seen, remember it

      # If there's no empty cell:
      #   return true

      # For candidate values v of our remembered row, col:
      #   board[row][col] = v
      #   if solve(board):
      #     return true

      # return false
     */

}
