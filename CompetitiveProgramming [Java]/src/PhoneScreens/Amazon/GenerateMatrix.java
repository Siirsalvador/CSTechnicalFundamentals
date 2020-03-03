package PhoneScreens.Amazon;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-17
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int num = 1;

        while (top <= bottom && left <= right) {

            //fill top row
            for (int col = left; col <= right; col++)
                matrix[top][col] = num++;


            //fill left col
            for (int row = top + 1; row <= bottom; row++)
                matrix[row][right] = num++;

            //fill bottom row
            for (int col = right - 1; col > left; col--)
                matrix[bottom][col] = num++;

            //fill right col
            for (int row = bottom; row > top; row--)
                matrix[row][left] = num++;


            top++;
            bottom--;

            left++;
            right--;

        }
        return matrix;
    }


}

