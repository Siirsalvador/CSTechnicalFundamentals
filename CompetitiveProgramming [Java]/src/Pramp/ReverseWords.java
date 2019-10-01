package Pramp;

import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-29
 */
public class ReverseWords {

    static public void main(String args[]) {

        System.out.println(Arrays.toString(reverseWords("Practice makes Perfect".toCharArray())));
    }

    /* You are given an array of characters arr that consists of sequences of characters separated by space characters.
      Each space-delimited sequence of characters defines a word.

      Implement a function reverseWords that reverses the order of the words in the array in the most efficient manner.

        input:  arr = [ 'p', 'e', 'r', 'f', 'e', 'c', 't', '  ',
                        'm', 'a', 'k', 'e', 's', '  ',
                        'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' ]

        output: [ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', '  ',
                 'm', 'a', 'k', 'e', 's', '  ',
                 'p', 'e', 'r', 'f', 'e', 'c', 't' ]


       [ A D A " " L I K E S " " R I C E]

       [ E C I R " " S E K I L " " A D A]

       left = 0
       right = 3 (E C I R) O(n/2 * n);

       for i < word.len, switch chars

       here:
       [ R I C E " " L I K E S " " A D A]
*/

    private static char[] reverseWords(char[] arr) {

        reverse(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

        int startIdx = 0;
        int endIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[startIdx] == ' ') startIdx++;
            if (arr[i] == ' ' || i == arr.length - 1) {
                endIdx = i == arr.length - 1 ? i : i - 1;
                reverse(arr, startIdx, endIdx);
                if (i + 1 < arr.length - 1) startIdx = i + 1;
            }

        }

        return arr;
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start <= end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    //['A', 'B', 'C'] ==> 0 -> 2 = 3 - 0 - 1
//    for(int i = 0;i<arr.length/2;i++){
//        char temp = arr[i];
//        arr[i] = arr[arr.length - i - 1];
//        arr[arr.length - i - 1] = temp;
//    }

}
