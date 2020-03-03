package ChiPractice.LP;

import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-05
 */
public class InfixToPrefixThenSolve {

    public static void main(String[] args) {
        String exp = "2+(4+3*2+1)/3";
        System.out.println(infixToPrefix(exp));
    }

    static String infixToPrefix(String expression) {
        Stack<Character> operands = new Stack<>();
        String output = "";

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);

            if (Character.isDigit(current)) {
                output = output.concat(String.valueOf(current));
                continue;
            }

            if (current == '(') {
                operands.add(current);
                continue;
            }

            if (isOperand(current)) {
                output = addOperandToStack(current, operands, output);
                continue;
            }

            if (current == ')') {
                output = updateOutput(operands, output);
            }

        }

        output = updateOutput(operands, output);

        return output;
    }

    private static String updateOutput(Stack<Character> operands, String output) {

        while (!operands.isEmpty()) {

            if (operands.peek() == '(') {
                operands.pop();
                break;
            }

            char current = operands.pop();
            output = output.concat(String.valueOf(current));
        }
        return output;
    }

    private static String addOperandToStack(char current, Stack<Character> operands, String output) {

        while (!operands.isEmpty() && isHigherOrEqualPrecedence(operands.peek(), current)) {
            char curr = operands.pop();
            output = output.concat(String.valueOf(curr));
        }

        operands.add(current);
        return output;
    }

    private static boolean isHigherOrEqualPrecedence(Character peek, char current) {
        if (current == '+' && (peek == '+' || peek == '-' || peek == '*' || peek == '/'))
            return true;

        if (current == '-' && (peek == '-' || peek == '*' || peek == '/'))
            return true;

        if (current == '*' && (peek == '*' || peek == '/'))
            return true;

        if (current == '/' && (peek == '/'))
            return true;

        return false;
    }

    private static boolean isOperand(char current) {
        return current == '+' || current == '-' || current == '*' || current == '/';
    }
}
