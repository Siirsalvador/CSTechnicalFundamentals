package PhoneScreens.Palantir;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-19
 */
public class Stobbogrammatic {

    public static void main(String[] args) {
        System.out.println(generateStrobbogrammatic(3));
    }

    // 1 6 8 9 1
    // 1 9 8 6 1

    // 0 6 9
    //0 9 6

    //9 9 6
    // 6 6 9 = 9 6 6


    static List<String> generateStrobbogrammatic(int n) {
        int[] nums = {0, 1, 6, 8, 9};
        List<String> list = new ArrayList<>();
        generate("", n, nums, list);
        return list;
    }

    private static void generate(String s, int len, int[] nums, List<String> list) {
        if (s.length() == len) {
            if (isStrobogrammatic(s)) list.add(s);
            return;
        }

        for (int num : nums) {
            generate(s + num, len, nums, list);
        }
    }

    private static boolean isStrobogrammatic(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char sChar = s.charAt(start);
            char eChar = s.charAt(end);

            if ((sChar == '6' && eChar != '9') || (sChar == '9' && eChar != '6'))
                return false;

            if ((sChar == '1' && eChar != '1') || (sChar == '8' && eChar != '8') || (sChar == '0' && eChar != '0'))
                return false;

            start++;
            end--;
        }

        return true;
    }
}
