package PhoneScreens.Facebook;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-31
 */
public class RandomSumQuery2D {
}


class NumMatrix {

    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        while (row1 <= row2) {
            int col = col1;
            while (col <= col2) {
                sum += matrix[row1][col];
                col++;
            }
            row1++;
        }

        return sum;
    }
}
