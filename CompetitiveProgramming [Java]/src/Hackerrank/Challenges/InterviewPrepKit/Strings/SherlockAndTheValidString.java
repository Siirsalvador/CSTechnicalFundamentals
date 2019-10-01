package Hackerrank.Challenges.InterviewPrepKit.Strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-19
 */
public class SherlockAndTheValidString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String result = isValid2(s);

        System.out.println(result);
    }

    private static String isValid2(String s) {

        final String NO = "NO";
        final String YES = "YES";

        if (s.isEmpty()) return NO;
        if (s.length() <= 3) return YES;

        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }

        Arrays.sort(letters);
        int i = 0;
        while (letters[i] == 0) {
            i++;
        }

        int min = letters[i];
        int max = letters[25];

        if (min == max) {
            return YES;
        } else {
            if (max - 1 == min && letters[24] == min | (min == 1) && (letters[i + 1] == max)) {
                return YES;
            }
        }

        return NO;
    }
}
