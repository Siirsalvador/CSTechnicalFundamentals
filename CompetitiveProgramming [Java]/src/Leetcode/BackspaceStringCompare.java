package Leetcode;

import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-04-09
 */
public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        char[] sChars = S.toCharArray();
        Stack<Character> sStk = new Stack<>();

        for (char c : sChars) {
            if (c == '#' && !sStk.isEmpty()) sStk.pop();
            if (c == '#') continue;
            else sStk.push(c);
        }

        char[] tChars = T.toCharArray();
        Stack<Character> tStk = new Stack<>();

        for (char c : tChars) {
            if (c == '#' && !tStk.isEmpty()) tStk.pop();
            if (c == '#') continue;
            else tStk.push(c);
        }

        return sStk.equals(tStk);
    }

    public boolean backspaceCompare2(String S, String T) {

        int sIdx = S.length() - 1, tIdx = T.length() - 1;
        int sBack = 0, tBack = 0;

        while (sIdx >= 0 || tIdx >= 0) {

            while (sIdx >= 0) {
                if (S.charAt(sIdx) == '#') {
                    sBack++;
                    sIdx--;
                } else if (sBack > 0) {
                    sBack--;
                    sIdx--;
                } else break;
            }

            while (tIdx >= 0) {
                if (T.charAt(tIdx) == '#') {
                    tBack++;
                    tIdx--;
                } else if (tBack > 0) {
                    tBack--;
                    tIdx--;
                } else break;
            }

            if (sIdx >= 0 && tIdx >= 0 && S.charAt(sIdx) != T.charAt(tIdx))
                return false;

            if ((sIdx >= 0) != (tIdx >= 0))
                return false;

            sIdx--;
            tIdx--;
        }

        return true;
    }

}
