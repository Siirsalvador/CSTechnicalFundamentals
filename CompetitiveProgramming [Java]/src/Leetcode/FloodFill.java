package Leetcode;

import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-20
 */
public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(Arrays.deepToString(floodFill(image, 1, 1, 2)));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor) helper(image, sr, sc, newColor, oldColor);
        return image;
    }

    public static void helper(int[][] image, int sr, int sc, int newColor, int oldColor) {

        if (image[sr][sc] == oldColor) {

            image[sr][sc] = newColor;

            //Left
            if (sc - 1 >= 0) {
                helper(image, sr, sc - 1, newColor, oldColor);
            }

            //Right
            if (sc + 1 < image[0].length) {
                helper(image, sr, sc + 1, newColor, oldColor);
            }

            //Top
            if (sr - 1 >= 0) {
                helper(image, sr - 1, sc, newColor, oldColor);
            }

            //Bottom
            if (sr + 1 < image.length) {
                helper(image, sr + 1, sc, newColor, oldColor);
            }

        }
    }
}
