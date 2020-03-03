package PhoneScreens.AmazonBloombergPalantir;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-03-01
 */
public class TicTacToeDesign {

    public static void main(String[] args) {
//        TicTacToe game = new TicTacToe(3);
//        System.out.println(game.move(0, 0, 1));
//        System.out.println(game.move(0, 2, 2));
//        System.out.println(game.move(2, 2, 1));
//        System.out.println(game.move(1, 1, 2));
//        System.out.println(game.move(2, 0, 1));
//        System.out.println(game.move(1, 0, 2));
//        System.out.println(game.move(2, 1, 1));

        TicTacToe game2 = new TicTacToe(2);
        System.out.println(game2.move(0, 1, 2));
        System.out.println(game2.move(1, 0, 1));
        System.out.println(game2.move(1, 1, 2));
    }

}

class TicTacToe {

    //To check if a row or column has n slots filled
    Map<String, Integer> map; //use string as key
    int width;

    TicTacToe(int n) {
        map = new HashMap<>();
        width = n;
    }

    public int move(int row, int col, int player) {
        String rowKey = player + ":" + "row:" + row;
        map.putIfAbsent(rowKey, 0);
        map.put(rowKey, map.get(rowKey) + 1);
        if (map.get(rowKey) == width) return player;

        String colKey = player + ":" + "col:" + col;
        map.putIfAbsent(colKey, 0);
        map.put(colKey, map.get(colKey) + 1);
        if (map.get(colKey) == width) return player;

        if (row - col == 0) {
            String diagKey = player + ":" + "diag:" + 0;
            map.putIfAbsent(diagKey, 0);
            map.put(diagKey, map.get(diagKey) + 1);
            if (map.get(diagKey) == width) return player;
        }

        if (row + col == width - 1) {
            int rc = row + col;
            String antiDiagKey = player + ":" + "aDiag:" + rc;
            map.putIfAbsent(antiDiagKey, 0);
            map.put(antiDiagKey, map.get(antiDiagKey) + 1);
            if (map.get(antiDiagKey) == width) return player;
        }

        return 0;
    }

}

class TicTacToe2 {
    //To check if a row or column has n slots filled
    Map<Integer, Integer> map;
    int width;

    TicTacToe2(int n) {
        map = new HashMap<>();
        width = n;
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        char key = 'X';
        if (player == 2) key = 'O';

        int rowKey = key * 100 + row;
        map.putIfAbsent(rowKey, 0);
        map.put(rowKey, map.get(rowKey) + 1);
        if (map.get(rowKey) == width)
            return player;

        int colKey = key * 200 + col;
        map.putIfAbsent(colKey, 0);
        map.put(colKey, map.get(colKey) + 1);
        if (map.get(colKey) == width)
            return player;

        if (row - col == 0) {
            int diagKey = key * 300 + 0;
            map.putIfAbsent(diagKey, 0);
            map.put(diagKey, map.get(diagKey) + 1);
            if (map.get(diagKey) == width)
                return player;
        }

        if (row + col == width - 1) {
            int rc = row + col;
            int antiDiagKey = key * 400 + rc;
            map.putIfAbsent(antiDiagKey, 0);
            map.put(antiDiagKey, map.get(antiDiagKey) + 1);
            if (map.get(antiDiagKey) == width)
                return player;
        }

        return 0;
    }
}

class TicTacToe3 {
    Map<String, int[]> map;
    int width;

    TicTacToe3(int n) {
        map = new HashMap<>();
        map.putIfAbsent("diag", new int[3]);
        map.putIfAbsent("antiDiag", new int[3]);
        width = n;
    }

    public int move(int row, int col, int player) {

        String rowKey = "r" + row;
        map.putIfAbsent(rowKey, new int[3]);
        map.get(rowKey)[player]++;

        String colKey = "r" + col;
        map.putIfAbsent(colKey, new int[3]);
        map.get(colKey)[player]++;

        if (row == col) {
            map.get("diag")[player]++;
        }

        if (row + col == width - 1) {
            map.get("antiDiag")[player]++;
        }

        return map.get(rowKey)[player] == width || map.get(colKey)[player] == width || map.get("diag")[player] == width
                || map.get("antiDiag")[player] == width ? player : 0;
    }


}
