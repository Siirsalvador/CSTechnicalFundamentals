package ChiPractice;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-01
 */
public class FindPlateaus {

    //Question 3 Find Plateaus. Print out as bool.
    /*
                <=
                1 2 3 4    0 0 0 0
                5 5 4 2    1 1 0 0
                5 1 1 8 -> 0 0 0 0
                0 0 0 9    0 0 0 0

    */
    static void findPlateau(int[][] map) {

        boolean[][] res = new boolean[map.length][map[0].length];


    }

    private static boolean check(int i, int j, int[][] map) {

        boolean high = true;
        int val = map[i][j];
        int rows = map.length;
        int cols = map[i].length;

        high = i == 0 || j == 0 || (map[i - 1][j - 1] < val);//upward left
        high &= i == 0 || map[i - 1][j] < val;//up
        high &= i == 0 || j == cols - 1 || map[i - 1][j + 1] < val; //upward right
        high &= j == 0 || map[i][j - 1] < val; //left
        high &= j == cols - 1 || map[i][j + 1] < val; //right
        high &= i == rows - 1 || j == 0 || map[i + 1][j - 1] < val; //downward left
        high &= i == rows - 1 || map[i + 1][j] < val; //down
        high &= i == rows - 1 || j == cols - 1 || map[i + 1][j + 1] < val; //downward right

        return high;
    }
}
