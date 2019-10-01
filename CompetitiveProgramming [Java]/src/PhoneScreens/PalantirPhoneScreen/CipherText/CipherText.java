package PhoneScreens.PalantirPhoneScreen.CipherText;

import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-31
 */
public class CipherText {

    public static void main(String[] args) {
        String message = "he12(!l(9lo wo)!-1r)ld";
        System.out.println(encrypt(message, 12));
    }

    public static String encrypt(String message, int shift) {
        shift = shift % 26;
        if (message == null || message.isEmpty()) return message;

        StringBuilder sb = new StringBuilder();
        boolean negative = false;
        boolean reverse = false;
        boolean isolate = false;

        int toremove = -1;
        boolean reverse2 = false;

        Stack<Integer> shifts = new Stack<>();
        Stack<Boolean> reverses = new Stack<>();
        String newMessage = "(" + message + ")";

        for (int i = 0; i < newMessage.length(); i++) {
            shift = shift % 26;
            char curr = newMessage.charAt(i);

            if (newMessage.charAt(i) == '(') isolate = true;

            if (newMessage.charAt(i) == ')') {
                isolate = false;
                reverse = reverse2;
                shift += toremove;
                toremove = -1;
            }

            if (isLowerCaseRelevant(curr)) {
                curr = (char) (curr + shift);
                if (curr > 'z') curr = (char) ('a' + curr - 'z' - 1);

                if (reverse) curr = (char) ('a' + 'z' - curr);
                negative = false;
            }

            if (isUpperCaseRelevant(curr)) {
                curr = (char) (curr + shift);
                if (curr > 'Z') curr = (char) ('A' + curr - 'Z' - 1);
                if (reverse) curr = (char) ('a' + 'z' - curr);
                negative = false;
            }

            if (newMessage.charAt(i) == '!') {
                if (isolate) {
                    reverse2 = reverse;
                }

                reverse = !reverse;
            }

            if (newMessage.charAt(i) == '-') {
                negative = true;
            }

            if (Character.isDigit(curr)) {
                String s = String.valueOf(curr);
                while (i + 1 < newMessage.length() && Character.isDigit(newMessage.charAt(i + 1))) {
                    s = s.concat(String.valueOf(newMessage.charAt(i + 1)));
                    i++;
                }

                if (isolate) {
                    if (negative) {
                        toremove += -1 * (Integer.parseInt(s));
                    } else {
                        toremove += Integer.parseInt(s);
                    }
                }

                shift = negative ? shift - Integer.parseInt(s) : shift + Integer.parseInt(s);
                sb.append(s);
                continue;
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
