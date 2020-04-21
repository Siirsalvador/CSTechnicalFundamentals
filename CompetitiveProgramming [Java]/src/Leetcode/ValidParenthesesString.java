package Leetcode;

import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-04-16
 */
public class ValidParenthesesString {

    public static void main(String[] args) {
        String s = "()";
        String s1 = "(*)";
        String s2 = "(*))";

        System.out.println(checkValidString(s));
        System.out.println(checkValidString(s1));
        System.out.println(checkValidString(s2));
    }

    public static boolean checkValidString(String s) {
        if (s == null)
            return false;

        if (s.isEmpty() || s.equals("*"))
            return true;

        Stack<Integer> brackets = new Stack<>();
        Stack<Integer> asterisks = new Stack<>();

        //(((*))
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c == '(')
                brackets.push(i);
            else if (c == '*')
                asterisks.push(i);
            else {

                if (brackets.size() > 0) brackets.pop();
                else if (asterisks.size() > 0) asterisks.pop();
                else return false;
            }
        }

        return brackets.size() <= asterisks.size() || brackets.isEmpty();
    }

    //10^N Time Complexity - First approach
    public static boolean checkValidStringExponential(String s) {
        if (s == null)
            return false;

        if (s.isEmpty() || (s.length() == 1 && s.equals("*")))
            return true;

        /*
            If '(', increase open
            if '*', increase open or decrease open
            if ')', decrease open if > 0, else return false

            in reverse:
            if ')', increase close
            if '*', increase close or decrease close
            if '(', decrease close idf > 0, else false
         */

        return validFromFront(s, 0, 0) && validFromBack(s, s.length() - 1, 0);
    }

    private static boolean validFromFront(String s, int idx, int open) {
        if (idx == s.length() && open == 0)
            return true;

        if (idx == s.length())
            return false;

        char curr = s.charAt(idx);
        boolean found = false;
        if (curr == '(') {
            found = validFromFront(s, idx + 1, open + 1);
        }

        if (curr == ')') {
            found = open > 0 && validFromFront(s, idx + 1, open - 1);
        }

        if (curr == '*') {
            found = validFromFront(s, idx + 1, open + 1) |
                    validFromFront(s, idx + 1, open - 1) |
                    validFromFront(s, idx + 1, open);
        }

        return found;
    }

    private static boolean validFromBack(String s, int idx, int close) {
        if (idx < 0 && close == 0)
            return true;

        if (idx < 0)
            return false;

        char curr = s.charAt(idx);
        boolean found = false;
        if (curr == ')') {
            found = validFromBack(s, idx - 1, close + 1);
        }

        if (curr == '(') {
            found = close > 0 && validFromBack(s, idx - 1, close - 1);
        }

        if (curr == '*') {
            found = validFromBack(s, idx - 1, close + 1) |
                    validFromBack(s, idx - 1, close - 1) |
                    validFromBack(s, idx - 1, close);
        }

        return found;
    }

    public boolean checkValidStringLinear(String s) {
        int lo = 0, hi = 0;
        for (char c : s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }
}
