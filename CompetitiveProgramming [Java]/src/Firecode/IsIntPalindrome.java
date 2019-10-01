package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-26
 */
public class IsIntPalindrome {
    public static Boolean isIntPalindrome(int x) {
        int num = x;

        int reverse = 0;
        while (num > 0) {
            int remainder = num % 10;
            reverse = (reverse * 10) + remainder;

            num = num / 10;
        }

        return reverse == x;
    }

    public static void main(String[] args){
        int num = 1221;
        System.out.println(isIntPalindrome(num));
    }
}
