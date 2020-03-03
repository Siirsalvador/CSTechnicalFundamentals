package PhoneScreens.AmazonBloombergPalantir;

import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-03-02
 */
public class CandyCrush2 {

    public static void main(String[] args) {
        String s = "aaabbbacd";
        System.out.println(crush(s));
    }

    public static String crush(String s) {
        if (s == null || s.isEmpty()) return "";

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {

            if (stack.size() >= 2) {
                Character first = stack.pop();
                Character second = stack.pop();

                if (first == c && second == c)
                    continue;

                stack.push(first);
                stack.push(second);
            }

            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
