package PhoneScreens.AmazonBloombergPalantir;

import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-25
 */
public class FloodFill {

    public static void main(String[] a){
        int[][] image = {{0,0,0},{0,1,1}};
        System.out.println(Arrays.deepToString(floodFill(image, 1, 1, 1)));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //You need an old color var. Use a helper method
        int oldColor = image[sr][sc];
        helper(image, sr, sc, newColor, oldColor);
        return image;
    }

    private static void helper(int[][] image, int sr, int sc, int newColor, int oldColor){
        if(newColor == oldColor || image == null || sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor)
            return;

        image[sr][sc] = newColor;
        //Top
        helper(image, sr - 1, sc, newColor, oldColor);

        //Bottom
        helper(image, sr + 1, sc, newColor, oldColor);

        //Left
        helper(image, sr, sc - 1, newColor, oldColor);

        //Right
        helper(image, sr, sc + 1, newColor, oldColor);
    }
}
