package PhoneScreens.Facebook;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-31
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() <= 1) return true;

        s = s.toLowerCase();

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {

            char charI = s.charAt(i);
            char charJ = s.charAt(j);

            if (!Character.isLetter(charI) && !Character.isDigit(charI)) {
                i++;
                continue;
            }

            if (!Character.isLetter(charJ) && !Character.isDigit(charJ)) {
                j--;
                continue;
            }

            if (charI != charJ) return false;

            i++;
            j--;
        }

        return true;
    }
}
