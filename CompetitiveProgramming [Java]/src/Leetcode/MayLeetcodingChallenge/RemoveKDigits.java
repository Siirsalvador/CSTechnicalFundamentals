package Leetcode.MayLeetcodingChallenge;

import java.util.Stack;

/**
 * @author: aoyekanmi
 * @date: 2020-05-13
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {

        if (num.length() == k)
            return "0";

        // int removeCnt = k;
        Stack<String> stack = new Stack<>();
        String[] nums = num.split("");
        for (int i = 0; i < nums.length; i++) {
            String c = nums[i];
            while (!stack.isEmpty() && c.compareTo(stack.peek()) < 0 && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }


        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() && k-- > 0) {
            stack.pop();
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        String res = sb.reverse().toString();

        if (res.isEmpty())
            return "0";

        res = res.replaceAll("^0+(?!$)", "");
        return res;
    }
}
