package Firecode.MinSumPathInTriangle;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-04
 */
public class GFGMinSumPathInTriangle {

    private static int A[][] = {{2},
            {3, 9},
            {1, 6, 7}};

    // Util function to find
    // minimum sum for a path
    private static int minSumPath() {

        // For storing the result
        // in a 1-D array, and
        // simultaneously updating
        // the result.
        int[] memo = new int[A.length];
        int n = A.length - 1;

        // For the bottom row
        for (int i = 0; i < A[n].length; i++)
            memo[i] = A[n][i];

        // Calculation of the
        // remaining rows, in
        // bottom up manner.
        for (int i = A.length - 2; i >= 0; i--)
            for (int j = 0; j < A[i + 1].length - 1; j++)
                memo[j] = A[i][j] + Math.min(memo[j], memo[j + 1]);

        // return the
        // top element
        return memo[0];
    }

    public static void main(String[] args) {
        System.out.print(minSumPath());
    }
}