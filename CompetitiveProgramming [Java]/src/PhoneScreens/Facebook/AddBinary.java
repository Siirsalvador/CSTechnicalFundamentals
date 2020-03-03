package PhoneScreens.Facebook;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-11
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";

        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        if (a == null && b == null) return "";
        if (a == null || a.isEmpty()) return b;
        if (b == null || b.isEmpty()) return a;


        StringBuilder result = new StringBuilder();

        int sum = 0;
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;

        while (aIdx >= 0 || bIdx >= 0 || sum == 1) {

            sum += aIdx >= 0 ? a.charAt(aIdx) - '0' : 0;
            sum += bIdx >= 0 ? b.charAt(bIdx) - '0' : 0;

            result.append((char) (sum % 2 + '0'));

            sum /= 2;
            aIdx--;
            bIdx--;
        }

        return result.reverse().toString();
    }
}
