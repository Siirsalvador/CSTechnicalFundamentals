package ChiPractice.GL;

import java.util.Collections;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-25
 */
public class DecompressStr {

/*
* Found an interesting Q:

    In this exercise, you’re going to decompress a compressed string.
    Your input is a compressed string of the format number[string] and the decompressed output form should be the string written number times. For example:
    The input 3[abc]4[ab]c
    Would be output as abcabcabcababababc
    Other rules
    Number can have more than one digit. For example, 10[a] is allowed, and just means aaaaaaaaaa
    One repetition can occur inside another. For example, 2[3[a]b] decompresses into aaabaaab
    Characters allowed as input include digits, small English letters and brackets [ ].
    Digits are only to represent amount of repetitions.
    Letters are just letters.
    Brackets are only part of syntax of writing repeated substring.

    I have a solution but the problem is meant to also test recursion. Any ideas on how to make this recursive?
*
* */

    static int idx = 0;
    private static int i = 0;

    //10[a]
    private static String decompressString(String str) {
        char start = '[';
        char end = ']';

        StringBuilder sb = new StringBuilder();
        int noOfRepeats = 0;

        while (i < str.length()) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                sb.append(ch);
                i++;
            } else if (Character.isDigit(ch)) {
                noOfRepeats = (noOfRepeats * 10) + (ch - '0');
                i++;
            } else if (ch == start) {
                i++;
                String strToRepeat = decompressString(str);
                for (int i = 0; i < noOfRepeats; i++) {
                    sb.append(strToRepeat);
                }
            } else if (ch == end) {
                i++;
                return sb.toString();
            }
        }
        return sb.toString();
    }

    private static String decodeString(String W) {
        StringBuilder s = new StringBuilder();

        while (i < W.length()) {
            if (W.charAt(i) == ']')
                break;

            s.append(Character.isDigit(W.charAt(i))
                    ? String.join("", Collections.nCopies(parseInt(i, W), decodeString(W)))
                    : W.charAt(i));

            i++;
        }

        return s.toString();
    }

    private static int parseInt(int startIndex, String W) {
        while (W.charAt(i++) != '[') ;
        return Integer.parseInt(W.substring(startIndex, i - 1));
    }

    private static String decompressStr(String str) {
        StringBuilder sb = new StringBuilder();

        int repeats = 0;
        while (idx < str.length()) {
            char currChar = str.charAt(idx);
            if (Character.isLetter(currChar)) {
                sb.append(currChar);
                idx++;
            } else if (Character.isDigit(currChar)) {
                repeats = (repeats * 10) + currChar - '0';
                idx++;
            } else if (currChar == '[') {
                idx++;
                String tempStr = decompressStr(str);
                for (int j = 0; j < repeats; j++) {
                    sb.append(tempStr);
                }
            } else if (currChar == ']') {
                idx++;
                return sb.toString();
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String string = "3[abc]4[ab]c";
        String string2 = "10[a]";
        String string3 = "k2[3[a]b]";

        System.out.println((decompressString(string3)));

    }
}
