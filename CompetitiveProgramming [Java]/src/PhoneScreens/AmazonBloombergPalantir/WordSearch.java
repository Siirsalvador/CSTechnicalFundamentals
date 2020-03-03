package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-02
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0) return false;

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && wordExists(i, j, board, 0, word, visited))
                    return true;
            }
        }

        return false;
    }

    private boolean wordExists(int row, int col, char[][] board, int currIdx, String word, boolean[][] visited) {

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col])
            return false;

        if (board[row][col] != word.charAt(currIdx))
            return false;

        if (currIdx == word.length() - 1)
            return true;

        visited[row][col] = true;
        boolean found = wordExists(row - 1, col, board, currIdx + 1, word, visited);
        if (!found) found = wordExists(row + 1, col, board, currIdx + 1, word, visited);
        if (!found) found = wordExists(row, col - 1, board, currIdx + 1, word, visited);
        if (!found) found = wordExists(row, col + 1, board, currIdx + 1, word, visited);

        visited[row][col] = false;
        return found;
    }
}
