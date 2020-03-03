package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-01
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {

        if (x < 0) return false;

        int xTmp = x;
        int reversed = 0;
        while (x > 0) { //121
            int currentDigit = x % 10;
            reversed = reversed * 10 + currentDigit;
            x = x / 10;
        }

        return xTmp == reversed;
    }
}
