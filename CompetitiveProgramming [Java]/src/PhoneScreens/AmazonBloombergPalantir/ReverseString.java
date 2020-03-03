package PhoneScreens.AmazonBloombergPalantir;

import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-13
 */
public class ReverseString {

    public static void main(String[] args) {
        String s = "Ayomide";
        System.out.println(reverse(s));
    }

    public static String reverseString(String str) {

        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }

        return reversed.toString();
    }

    public static String reverse(String s) {
        char[] words = s.toCharArray();
        helper(words, 0, s.length() - 1);

        return Arrays.toString(words);
    }

    private static void helper(char[] words, int start, int end) {

        while (start <= end) {
            char temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }
    }
}
