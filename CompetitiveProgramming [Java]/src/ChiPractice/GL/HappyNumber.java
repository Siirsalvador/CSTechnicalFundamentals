package ChiPractice.GL;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-02
 */
public class HappyNumber {

    /*
        A number is Happy (Yes, it is a thing!) if it follows a sequence that ends in 1 after following the steps given below :
        Beginning with the number itself, replace it by the sum of the squares of its digits until either the number becomes 1 or loops endlessly in a cycle that does not include 1.
        For instance, 19 is a happy number. Sequence:
        12 + 92 = 82
        82 + 22 = 68
        62 + 82 = 100
        12 + 02 + 02 = 1 (edited)

        The solution under just implements the question naively. It’s not a bad solution acc but the solution above uses the KinkedList runner concept because in a way, the numbers we calculate sort of form a linked list
        Mind = BLOWN
     */

    public static boolean isHappyNumber2(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = next(slow);
            fast = next(next(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private static int next(int n) {
        int res = 0;
        while (n > 0) {
            int digit = n % 10;
            res += digit * digit;
            n /= 10;
        }
        return res;
    }

    public static boolean isHappyNumber(int n) {

        Set<Integer> vals = new HashSet<>();
        while (true) {
            String digits = String.valueOf(n);
            int sum = 0;
            for (int i = 0; i < digits.length(); i++) {
                sum += Math.pow(Character.getNumericValue(digits.charAt(i)), 2);
            }
            if (sum == 1) return true;
            if (vals.contains(sum)) return false;
            else vals.add(sum);
            n = sum;
        }
    }

}
