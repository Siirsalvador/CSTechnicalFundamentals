package Firecode;

import java.util.ArrayList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-29
 */
public class PrintPathsOnGame {

    public static ArrayList<String> printPaths(char[][] board) {

        //Create a string
        //Create ArrayList
        //just keep adding the current string to the string
        //until we get to m = 1 || n == 1 add to arrayList
        //return arrayList
        int rows = 0;
        int cols = 0;

        String paths = "";
        ArrayList<String> listOfPaths = new ArrayList<>();
        printPaths(board, rows, cols, paths, listOfPaths);
        return listOfPaths;
    }

    private static void printPaths(char[][] board, int rows, int cols, String paths, ArrayList<String> listOfPaths) {

        if (rows == board.length - 1 && cols == board[0].length - 1) {
            paths += board[rows][cols];
            listOfPaths.add(paths);
            return;
        }

        if (rows == board.length || cols == board[0].length) return;

        paths += board[rows][cols];
        printPaths(board, rows + 1, cols, paths, listOfPaths);
        printPaths(board, rows, cols + 1, paths, listOfPaths);
    }

    public static void main(String[] args) {
        char[][] arr = {{'A', 'X'}, {'D', 'E'}};
        System.out.println(printPaths(arr));
    }
}
