package Firecode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-26
 */
public class TransposeMatrix {
    public static void transposeMatrix(int[][] matrix) {
    /*
    1 2 3
    4 5 6
    7 8 9

    (0,0)
    (1,0) = (0,1)
    (2,0) = (0,2)
    (1,1)
    (2,1) = (1,2)
    (2,2)

    i

    cols = 3
    rows = 3

    7 (3,0)
    3 (0,3)
    */

        int size = matrix.length;

        int i = 0, j = 0;

        while(i < size && j < size){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;

            if(i == size - 1){
                j++;
            }else {
                i++;
            }

        }

    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        transposeMatrix(matrix);
        System.out.println(Arrays.deepToString(matrix));

        matrix = new int[][]{{1, 0, 1}, {1, 0, 1}, {1, 0, 1}};
        transposeMatrix(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
