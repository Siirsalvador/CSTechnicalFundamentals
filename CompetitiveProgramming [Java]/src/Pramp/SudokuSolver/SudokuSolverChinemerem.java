package Pramp.SudokuSolver;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-27
 */


/*
Sudoku Solver
Write the function sudokuSolve that checks whether a given sudoku board (i.e.      sudoku puzzle) is solvable. If so, the function will returns true.  Otherwise (i.e. there is no valid solution to the given sudoku board), returns false.

In sudoku, the objective is to fill a 9x9 board with digits so that each column, each row, and each of the nine 3x3 sub-boards that compose the board contains all of the digits from 1 to 9. The board setter provides a partially completed board, which for a well-posed board has a unique solution. As explained above, for this problem, it suffices to calculate whether a given sudoku board has a solution. No need to return the actual numbers that make up a solution.

A sudoku board is represented as a two-dimensional 9x9 array of the characters ‘1’,‘2’,…,‘9’ and the '.' character, which represents a blank space. The function should fill the blank spaces with characters such that the following rules apply:

In every row of the array, all characters ‘1’,‘2’,…,‘9’ appear exactly once.
In every column of the array, all characters ‘1’,‘2’,…,‘9’ appear exactly once.
In every 3x3 sub-board that is illustrated below, all characters ‘1’,‘2’,…,‘9’ appear exactly once.

A solved sudoku is a board with no blank spaces, i.e. all blank spaces are filled with characters that abide to the constraints above. If the function succeeds in solving the sudoku board, it’ll return true (false, otherwise).

Example:

    sudoku(board)

    i=0,j=2

    {'5','3','.','&','7','.','.','.','.'},
    {'6','.','.','1','9','5','.','.','.'},
    {'.','9','8','#','.','.','.','6','.'},
    {'8','.','.','.','6','.','.','.','3'},
    {'4','.','.','8','.','3','.','.','1'},
    {'7','.','.','.','2','.','.','.','6'},
    {'.','6','.','.','.','.','2*,'8','.'},
    {'.','.','.','4','1','9','.','.','5'},
    {'.','.','.','.','8','.','.','7','9'};

    {'5','3','4','6','7','8','9','1','2'},
    {'6','7','2','1','9','5','3','4','8'},
    {'1','9','8','3','4','2','5','6','7'},
    {'8','5','9','7','6','1','4','2','3'},
    {'4','2','6','8','5','3','7','9','1'},
    {'7','1','3','9','2','4','8','5','6'},
    {'9','6','1','5','3','7','2','8','.'},
    {'2','8','7','4','1','9','6','3','5'},
    {'3','4','5','2','8','6','1','7','9'};

 */
public class SudokuSolverChinemerem {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '.', '6', '8', '.', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '.', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '.'},
                {'2', '8', '.', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
        };

        System.out.println(sudokuSolve(board));
        System.out.println(Arrays.deepToString(board));
    }

    static boolean sudokuSolve(char[][] board) {
        // Write your code here :D

        //
        List<Character> possibles = new ArrayList<>();
        int row = -1;
        int col = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    possibles = getPossibles(i, j, board);
                    if (possibles.isEmpty()) {
                        System.out.println(board[row][col]);
                        return false;
                    }
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        if (row == -1 && col == -1) {
            return true;
        }

        for (char c : possibles) {
            board[row][col] = c;
            if (sudokuSolve(board)) {
                return true;
            }
            board[row][col] = '.';
        }

        return false;
    }

    //static boolean solveSudoku()

    static List<Character> getPossibles(int row, int col, char[][] board) {

        Set<Character> res = new HashSet<>();
        for (char i = '1'; i < '9'; i++) res.add(i);

        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] != '.') {
                res.remove(board[row][i]);
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != '.') {
                res.remove(board[i][col]);
            }
        }

        //points (5,6) == 1,2 * 3 -> <3,6>
        //points (2,3) == 0, 1 * 3 -> <0, 3>
        //points (7,8) == <=2, 2 * 3 -> <
        int r = row / 3 * 3;
        int c = col / 3 * 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] != '.') {
                    res.remove(board[i][j]);
                }
            }
        }

        return new ArrayList<>(res);
    }

}
