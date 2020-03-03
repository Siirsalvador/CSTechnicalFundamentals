package PhoneScreens.Facebook;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-31
 */
public class ValidPalindromeII {

    public static void main(String[] a) {
        String s = "cbbcc";
        System.out.println(validPalindrome2(s));

//        CharSequence cs = "a";
//        System.out.println(cs);
    }




    public static boolean validPalindrome(String s) {
        if(s == null) return false;

        int i = 0;
        int j = s.length() - 1;

        while(i < j){
            if (s.charAt(i) != s.charAt(j)) {

                return palindromeChecker(i + 1, j, s) ||
                        palindromeChecker(i, j -1, s);
            }

            i++;
            j--;
        }

        return true;
    }

    private static boolean palindromeChecker(int i, int j, String s) {

        while(i < j){
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }

    public static boolean validPalindrome2(String s) {

        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            int j = len - 1 - i;
            if (s.charAt(i) != s.charAt(j)) {

                return palindromeChecker(s.substring(i + 1, j + 1)) ||
                        palindromeChecker(s.substring(i, j));
            }

        }

        return true;
    }

    private static boolean palindromeChecker(String s) {

        int len = s.length();
        if (len == 2) return s.charAt(0) == s.charAt(1);

        for (int i = 0; i < len / 2; i++) {
            int j = len - 1 - i;
            if (s.charAt(i) != s.charAt(j)) return false;
        }

        return true;
    }
}
