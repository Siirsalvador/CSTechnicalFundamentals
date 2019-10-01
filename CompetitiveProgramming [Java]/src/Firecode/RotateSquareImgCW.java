package Firecode;

import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-07
 */
public class RotateSquareImgCW {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateSquareImageCW(arr);
    }

    public static void rotateSquareImageCW(int[][] matrix) {
    /*
        1 2 3
        4 5 6
        7 8 9

        1 4 7
        2 5 8
        3 6 9

        7 4 1
        8 5 2
        9 6 3

        3 6 9
        2 5 8
        1 4 7

        Transpose then vertical flip.
    */

        //Transpose
        int size = matrix.length;

        int i = 0, j = 0;

        while (i < size && j < size) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;

            if (i == size - 1) {
                j++;
            } else {
                i++;
            }
        }

        System.out.println(Arrays.deepToString(matrix));

        //Vertical Flip
        for (int[] ints : matrix) {
            reverseColumns(ints, 0, ints.length - 1);
        }

        System.out.println(Arrays.deepToString(matrix));

    }

    private static void reverseColumns(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}
