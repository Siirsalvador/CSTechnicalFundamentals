package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-13
 */
public class TwoStringsSubstring {

    public static void main(String[] args) {
        String s = "string";
        String s2 = "substring";
        System.out.println(checkIfSubstring(s, s2));
    }

    private static boolean checkIfSubstring(String s, String s2) {
        if (s == null || s2 == null) return false;
        if (s.length() == s2.length()) return s.equals(s2);


        if (s.length() > s2.length()) {
            String temp = s;
            s = s2;
            s2 = temp;
        }

        int i = 0;
        int j = 0;
        while (i < s.length() && j < s2.length()) {

            if (s.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i = 0;
                j++;
            }

        }

        return i == s.length();
    }
}
