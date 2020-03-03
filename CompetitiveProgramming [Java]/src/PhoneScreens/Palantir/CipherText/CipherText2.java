package PhoneScreens.Palantir.CipherText;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-05
 */
public class CipherText2 {

    public static void main(String[] args) {
        System.out.println(caesarCipher("he12l9lo wo-1rld", 7));
    }

    private static String caesarCipher(String message, int shift) {

        if (message == null) return message;
        message = message.toLowerCase();

        StringBuilder sb = new StringBuilder();
        boolean isNegative = false ;

        for (int i = 0; i < message.length(); i++) {
            shift = shift % 26;
            char curr = message.charAt(i);
             String temp = String.valueOf(curr);

            if (isLowerCaseRelevant(curr)) {
                curr = (char) (curr + shift);
                if (curr > 'z') curr = (char) ('a' + curr - 'z' - 1);
                temp = String.valueOf(curr);
            }

            if (curr == '-') isNegative = true;

            if (Character.isDigit(curr)) {
                while (i + 1 < message.length() && Character.isDigit(message.charAt(i + 1))) {
                    temp = temp.concat(String.valueOf(message.charAt(i + 1)));
                    i++;
                }

                int num = Integer.parseInt(temp);
                if ( isNegative) num *= -1;
                shift = increment(shift, num);
                isNegative = false;
            }

            sb.append(temp);
        }

        return sb.toString();

    }

    private static boolean isLowerCaseRelevant(char c) {
        return c >= 'a' && c <= 'z';
    }

    private static int increment(int total, int num) {
        return total + num;
    }
}
