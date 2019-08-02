package ChiPractice.GS;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-02
 */
public class ParseInt {

    public int convertStringToInt(String s) {

        boolean isNegative = false;
        int j = 0;

        if (s.charAt(0) == '-') {
            isNegative = true;
            j++;
        }

        if (s.charAt(0) == '+') {
            j++;
        }

        int number = 0;

        for (int i = j; i < s.length(); i++) {

            int currentAscii = (int) s.charAt(i);

            if (currentAscii >= 48 && currentAscii <= 57) {

                number = (number * 10) + (currentAscii - 48);

            } else {
                throw new NumberFormatException("This is not a valid number");
            }
        }

        if (isNegative) {
            number *= -1;
        }

        return number;
    }
}
