package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-24
 */
public class BoggleBoard {

    public static void main(String[] args) {

//        char[][] board = {
//                {'A', 'O', 'L'},
//                {'D', 'E', 'L'},
//                {'G', 'H', 'I'},
//        };
//
//        System.out.println(boggleSearch(board, "HELLO"));
//
//        char[][] board2 = {
//                {'A','F','A','J'},
//                {'S','I','V','A'},
//                {'E','R','O','C'},
//                {'C','X','E','K'},
//                {'O','D','F','S'},
//                {'D','E','E','E'}
//        };
//
//        System.out.println(boggleSearch(board2, "AXE"));

        /*

            ["A","B","C","E"],
            ["S","F","E","S"],
            ["A","D","E","E"]]
            "ABCESEEEFS"
         */

//        char[][] board3 = {{'a', 'a'}};
//        System.out.println(boggleSearch(board3, "aaa"));

        char[][] board4 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(boggleSearch(board4, "ABCESEEEFS"));
    }

    public static boolean boggleSearch(char[][] board, String word) {

        //DFS
        /*
         * iterate through matrix, if I find first letter, perform dfs to check if it can form our word
         * if yes, return true. if no, continue iteration.
         * continue until word is found or matrix is complete
         * */
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0) && doesWordExist(board, row, col, word, 0, visited))
                    return true;
            }
        }

        return false;
    }

    private static boolean doesWordExist(char[][] board, int row, int col, String word, int wordIdx, boolean[][] visited) {

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col])
            return false;

        if (board[row][col] != word.charAt(wordIdx))
            return false;

        if (wordIdx == word.length() - 1)
            return true;

        visited[row][col] = true;

        boolean found = doesWordExist(board, row - 1, col, word, wordIdx + 1, visited);
        if (!found)
            found = doesWordExist(board, row + 1, col, word, wordIdx + 1, visited);
        if (!found)
            found = doesWordExist(board, row, col - 1, word, wordIdx + 1, visited);
        if (!found)
            found = doesWordExist(board, row, col + 1, word, wordIdx + 1, visited);
        visited[row][col] = false;

        return found;
    }

}
