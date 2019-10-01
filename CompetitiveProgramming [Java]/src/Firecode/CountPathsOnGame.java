package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-23
 */
public class CountPathsOnGame {

    /*
        0 1 2
      0 A B C
      1 D E F
      2 G H I
     */

    public int countPaths(int m, int n) {
        int[][] dynStore = new int[m + 1][n + 1];
        return countPaths(m, n, dynStore);
    }

    private int countPaths(int m, int n, int[][] dynStore) {
        if (m == 1 || n == 1) return 1;

        if (dynStore[m][n] == 0) {
            dynStore[m][n] = countPaths(m - 1, n, dynStore) + countPaths(m, n - 1, dynStore);
        }

        return dynStore[m][n];
    }
}
