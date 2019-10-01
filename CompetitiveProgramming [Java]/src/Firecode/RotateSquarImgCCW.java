package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-28
 */
public class RotateSquarImgCCW {

    public static void rotateSquareImageCCW(int[][] matrix) {

        findTranspose(matrix);
        horizontalFlip(matrix);
    }

    private static void horizontalFlip(int[][] matrix) {

        int start = 0;
        int end = matrix.length;

        while (start <= end) {
            int[] temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;

            start++;
            end--;
        }
    }

    private static void findTranspose(int[][] matrix) {

        int size = matrix.length;
        int i = 0;
        int j = 0;

        while (i < size && j < size) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;

            if (i == size - 1) j++;
            else i++;
        }
    }
}
