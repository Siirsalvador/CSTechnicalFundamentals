package PhoneScreens.PalantirPhoneScreen.CipherText;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-05
 */
public class CipherText1 {

    public static void main(String[] args) {
        System.out.println(caesarCipher("he2l9lo wo1rld@", 3));
    }

    private static String caesarCipher(String message, int shift) {

        if (message == null) return message;
        message = message.toLowerCase();

        StringBuilder sb = new StringBuilder();
        boolean isDoubleDigit = false;

        for (int i = 0; i < message.length(); i++) {
            shift = shift % 26;
            char curr = message.charAt(i);

            if (isLowerCaseRelevant(curr)) {
                curr = (char) (curr + shift);
                if (curr > 'z') curr = (char) ('a' + curr - 'z' - 1);
            }

            if (!Character.isDigit(curr)) isDoubleDigit = false;
            if (Character.isDigit(curr)) {
                if (isDoubleDigit) return message;
                isDoubleDigit = true;
                shift += Integer.parseInt(String.valueOf(curr));
            }

            sb.append(curr);
        }

        return sb.toString();

    }

    private static boolean isLowerCaseRelevant(char c) {
        return c >= 'a' && c <= 'z';
    }
}
