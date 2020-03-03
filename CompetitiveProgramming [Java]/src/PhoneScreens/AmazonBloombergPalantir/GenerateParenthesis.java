package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-18
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n > 0) {
            helper(n, n, "", result);
        }

        return result;
    }

    private void helper(int left, int right, String s, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }

        if (left > 0) {
            helper(left - 1, right, s + "(", result);
        }

        if (right > left) {
            helper(left, right - 1, s + ")", result);
        }
    }
}
