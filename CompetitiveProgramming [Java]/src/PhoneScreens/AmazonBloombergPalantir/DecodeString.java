package PhoneScreens.AmazonBloombergPalantir;

import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-02
 */
public class DecodeString {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString2(s));
    }

    public static String decodeString(String s) {
        if (s == null || s.isEmpty()) return "";

        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) { //n^
            if (c != ']') {
                stack.push(c);
            } else {

                //Get string to evaluate
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek()))
                    sb.insert(0, stack.pop());
                String sub = sb.toString();

                stack.pop();

                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek()))
                    sb.insert(0, stack.pop());
                int repeat = Integer.valueOf(sb.toString());

                while (repeat > 0) {
                    for (Character ch : sub.toCharArray()) {
                        stack.push(ch);
                    }
                    repeat--;
                }
            }
        }


        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }

        return res.toString();
    }

    public static String decodeString2(String s) {
        if (s == null || s.isEmpty()) return "";

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
                continue;
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                sb.append(stack.pop());
            }
            String add = sb.reverse().toString();

            stack.pop();
            sb = new StringBuilder();
            while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                sb.append(stack.pop());
            }

            int repeat = Integer.parseInt(sb.reverse().toString());
            while (repeat-- > 0) {
                for (char a : add.toCharArray()) {
                    stack.push(a);
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}
