package Firecode;

import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-26
 */
public class FirstNonRepeatedChar {
    public static Character firstNonRepeatedCharacter(String str) {
        if (str == null || str.isEmpty()) return null;

        int[] chars = new int[256];
        for (int i = 0; i < str.length(); i++) {
            chars[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (chars[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String str = "aabcdc";
        System.out.println(firstNonRepeatedCharacter(str));

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.toString(matrix[0]));
    }
}
