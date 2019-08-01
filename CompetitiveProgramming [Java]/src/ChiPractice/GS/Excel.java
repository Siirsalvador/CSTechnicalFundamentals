package ChiPractice.GS;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-01
 */
public class Excel {

    private static int getColumnNumber(String s) {
        //Convert from base 26 to 10
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            result *= 26;
            result += s.charAt(i) - 'A' + 1;
        }

        return result;
    }

    private static String getColumnName(int s) {

        StringBuilder stringBuilder = new StringBuilder();

        //Convert from base 10 to base 26
        while (s != 0) {

            int remainder = s % 26;

            if (remainder == 0) {
                stringBuilder.append("Z");
                s = (s / 26) - 1;
            } else {
                stringBuilder.append((char) remainder - 1 + 'A');
                s = s / 26;
            }
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.print(getColumnNumber("CDA"));
    }
}