package Firecode;

import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-24
 */
public class Flip2DMatrix {

    private static void flipItVerticalAxis(int[][] matrix) {

        for (int[] aRow : matrix) {
            reverse(aRow, 0, aRow.length);
        }

    }

    private static void reverse(int[] aRow, int start, int stop) {
        while (start <= stop) {
            int temp = aRow[start];
            aRow[start] = aRow[stop];
            aRow[stop] = temp;
            start++;
            stop--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 2, 1}, {6, 5, 4}, {9, 8, 7}};
        flipItVerticalAxis(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
