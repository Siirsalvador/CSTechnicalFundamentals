package PhoneScreens.Palantir;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-26
 */

class CandyCrush {


    private int[][] board;

    CandyCrush(int[][] board) {
        this.board = board;
    }

    public int[][] crushCandies() {

        boolean crushed = false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] > 0) {
                    Set<Integer> crushables = new HashSet<>();
                    findCrushables(i, j, board[i][j], board, crushables);
                    if (crushables.size() >= 3) {
                        crushed = true;
                        crushPositions();
                    }
                }
            }
        }

        return crushed ? crushCandies() : this.board;
    }

    private void crushPositions() {
        //Columns
        for (int col = 0; col < board[0].length; col++) {
            int rowPointer = board.length - 1;
            for (int row = board.length - 1; row >= 0; row--) {
                if (this.board[row][col] > 0) {
                    board[rowPointer][col] = board[row][col];
                    rowPointer--;
                }
            }

            while (rowPointer-- >= 0) {
                this.board[rowPointer][col] = 0;
            }
        }

    }

    private void findCrushables(int i, int j, int val, int[][] board, Set<Integer> set) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != val) {
            return;
        }

        int id = i * 10 + j;
        if (set.contains(id)) {
            return;
        }

        set.add(id);
        board[i][j] = -board[i][j];
        findCrushables(i + 1, j, val, board, set);
        findCrushables(i - 1, j, val, board, set);
        findCrushables(i, j + 1, val, board, set);
        findCrushables(i, j - 1, val, board, set);
    }


}