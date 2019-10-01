package PhoneScreens.PalantirPhoneScreen.Practice;

import java.util.Scanner;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-28
 */
public class CaesarCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int strLen = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String plainStr = scanner.nextLine();

        int rotateFactor = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();

        String result = caesarCipher(plainStr, rotateFactor);
        System.out.println(result);
        String deResult = decodeCaesarCipher(result, rotateFactor);
        System.out.println(deResult);
    }

    private static String caesarCipher(String message, int shift) {

        shift = shift % 26;
        if (message == null) return message;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char curr = message.charAt(i);
            if (isLowerCaseRelevant(curr)) {
                curr = (char) (curr + shift);
                if (curr > 'z') curr = (char) ('a' + curr - 'z' - 1);
            }

            if (isUpperCaseRelevant(curr)) {
                curr = (char) (curr + shift);
                if (curr > 'Z') curr = (char) ('A' + curr - 'Z' - 1);
            }

            sb.append(curr);
        }

        return sb.toString();

    }

    private static String decodeCaesarCipher(String s, int k) {

        if (s == null) return s;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (isLowerCaseRelevant(curr)) {
                curr = (char) (curr - k);
                if (curr < 'a') curr = (char) ('z' - 'a' - curr - 1);
            }

            if (isUpperCaseRelevant(curr)) {
                curr = (char) (curr - k);
                if (curr < 'A') curr = (char) ('Z' - 'A' - curr - 1);
            }

            sb.append(curr);
        }

        return sb.toString();
    }

    private static boolean isLowerCaseRelevant(char c) {
        return c >= 'a' && c <= 'z';
    }

    private static boolean isUpperCaseRelevant(char c) {
        return c >= 'A' && c <= 'Z';
    }
}

