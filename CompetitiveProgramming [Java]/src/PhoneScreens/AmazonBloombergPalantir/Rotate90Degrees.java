package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-25
 */
public class Rotate90Degrees {

    public void rotate(int[][] matrix) {
        //Transpose then vertical flip

        //Transpose
        /**
         0,0
         1,0 = 0,1
         1,1

         2,0 = 0,2
         2,1 = 1,2
         2,2

         3,0 = 0,3
         3,1 = 1,3
         3,2 = 2,3
         3,3
         */

        int row = 0;
        int col = 0;
        while (row < matrix.length && col < matrix[0].length) {
            int temp = matrix[row][col];
            matrix[row][col] = matrix[col][row];
            matrix[col][row] = temp;

            if (row == col) {
                row++;
                col = 0;
            } else {
                col++;
            }
        }

        for (int[] cols : matrix) {
            reverse(cols);
        }
    }

    private void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}
