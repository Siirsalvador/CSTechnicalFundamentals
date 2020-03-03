package PhoneScreens.Facebook;

import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-16
 */
public class SparseMatrixMultiplication {

    public static void main(String[] args) {
        int[][] A = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[][] B = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};

        System.out.println(Arrays.deepToString(multiply(A, B)));
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0)
            return new int[0][0];

        int row = 0;
        int col = 0;
        int[][] result = new int[A.length][B[0].length];

        while (row < A.length && col < B[0].length) {

            result[row][col] = calculateValue(row, A, col, B);

            if (col + 1 < B[0].length) {
                col++;
            } else {
                row++;
                col = 0;
            }
        }

        return result;
    }

    private static int calculateValue(int r, int[][] A, int c, int[][] B) {

        int[] row = Arrays.copyOf(A[r], A[r].length);

        for (int i = 0; i < B.length; i++) {
            row[i] *= B[i][c];
        }

        int sum = 0;
        for (int rw : row) sum += rw;
        return sum;
    }
}
