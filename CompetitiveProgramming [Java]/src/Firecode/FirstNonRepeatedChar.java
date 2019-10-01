package Firecode;

import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-26
 */
public class FirstNonRepeatedChar {
    public static Character firstNonRepeatedCharacter(String str) {
        int[] arr = new int[256];

        for(int i = 0; i < str.length(); i++){
            int charVal = str.charAt(i) - 97 + 1;
            arr[charVal]++;
        }

        System.out.println(Arrays.toString(arr));

        int charVal = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1){
                System.out.println(i);
                charVal = (i - 1) + 97;
                return (char) charVal;
            }
        }

        return null;
    }

    public static void main(String[] args){
        String str = "aabcdc";
        System.out.println(firstNonRepeatedCharacter(str));

        int[][] matrix = {{1,2,3}, {4,5,6}};
        System.out.println(Arrays.toString(matrix[0]));
    }
}
