package Hackerrank.Challenges.InterviewPrepKit.Strings;

import java.util.Scanner;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-23
 */
public class SpecialStringAgain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        System.out.println(substrCount(s));


        scanner.close();
    }

    //All of the characters are the same, e.g. aaa.
    //All characters except the middle one are the same, e.g. aadaa.
    private static long substrCount(String s) {

        long count = 0;
        for (int i = 0; i < s.length(); i++) {

            //Check for if current char is in the middle of one or more palindromes E.g. aabaa has 2 palindromes, aba and aabaa. So we must cater for the 2.
            int offset = 1;
            while (i - offset >= 0 && i + offset < s.length() && s.charAt(i - 1) == s.charAt(i - offset) && s.charAt(i - 1) == s.charAt(i + offset)) {
                count++;
                offset++; //increase offset to check if there is more than one palindrome for that middle ele
            }

            int repeated = 0;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                repeated++;
                i++;
            }

            //Formula: n*(n+1)/2
            count += repeated * (repeated + 1) / 2;
        }

        return count + s.length();
    }
}
