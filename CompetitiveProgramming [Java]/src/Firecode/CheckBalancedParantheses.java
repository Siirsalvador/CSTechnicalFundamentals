package Firecode;

import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-07
 */
public class CheckBalancedParantheses {

    public static boolean isBalanced(String input) {
        if (input == null || input.isEmpty()) return false;

        //Use stack
        Stack<Character> brackets = new Stack<>();

        for (char aChar : input.toCharArray()) {
            //if ( or { or [, insert
            if (aChar == '(' || aChar == '[' || aChar == '{') brackets.add(aChar);
            else {
                if (brackets.isEmpty()) return false;
                char curr = brackets.pop();
                if (!bracketsMatch(curr, aChar)) return false;
            }
            //else if ) or } or ], pop and check if it matches, return false if no
        }

        return brackets.isEmpty();
    }

    public static boolean bracketsMatch(char curr, char aChar) {
        if (curr == '(' && aChar == ')') return true;
        else if (curr == '[' && aChar == ']') return true;
        else return curr == '{' && aChar == '}';
    }

    public static boolean isBalancedRecursive(String input) {
        if (input == null || input.isEmpty()) return false;

        //Use stack
        Stack<Character> brackets = new Stack<>();
        brackets.add(input.charAt(0));
        int idx = 1;

        return areBracketsBalanced(brackets, input, idx);
    }

    public static boolean areBracketsBalanced(Stack<Character> brackets, String input, int idx) {
        if (idx  == input.length()) return brackets.isEmpty();

        char aChar = input.charAt(idx);
        if (aChar == '(' || aChar == '[' || aChar == '{') {
            brackets.add(aChar);
            idx++;
            return areBracketsBalanced(brackets, input, idx);
        } else {
            if(brackets.isEmpty()) return false;
            char curr = brackets.pop();
            idx++;
            return bracketsMatch(curr, aChar) && areBracketsBalanced(brackets, input, idx);
        }
    }

    public static void main(String[] args) {
        String input = "[](){}";
        System.out.println(isBalancedRecursive(input));
    }
}
