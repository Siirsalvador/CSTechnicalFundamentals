package PhoneScreens.Facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-31
 */
public class ExpressionAddOperators {

    public static void main(String[] args) {
        System.out.println(addOperators("232", 8));
    }

    /*
        Input: num = "123", target = 6
        Output: ["1+2+3", "1*2*3"]
        Example 2:

        Input: num = "232", target = 8
        Output: ["2*3+2", "2+3*2"]
        Example 3:

        Input: num = "105", target = 5
        Output: ["1*0+5","10-5"]
        Example 4:

        Input: num = "00", target = 0
        Output: ["0+0", "0-0", "0*0"]

     */

    public static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        char[] arr = num.toCharArray();

        Stack<Number> stack = new Stack<>();
        Number n = new Number(0, arr[0] - '0', "" + arr[0]);
        stack.add(n);

        while (!stack.isEmpty()) {
            Number curr = stack.pop();

            if (curr.idx == arr.length - 1 && curr.val == target) {
                res.add(curr.curr);
                continue;
            }

            if (curr.idx == arr.length - 1) continue;


            int newIdx = curr.idx + 1;
            char newChar = arr[newIdx];

            int newNum = newChar - '0';

            stack.add(new Number(newIdx, curr.val + newNum, curr.curr + "+" + arr[newIdx]));
            stack.add(new Number(newIdx, curr.val - newNum, curr.curr + "-" + arr[newIdx]));
            stack.add(new Number(newIdx, curr.val * newNum, curr.curr + "*" + arr[newIdx]));
        }

        return res;

    }
}


class Number {
    int idx;
    int val;
    String curr;

    Number(int idx, int val, String curr) {
        this.idx = idx;
        this.val = val;
        this.curr = curr;
    }
}