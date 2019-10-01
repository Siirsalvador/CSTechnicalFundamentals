package Hackerrank.Challenges.InterviewPrepKit.Strings;

import java.util.Scanner;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-19
 */
public class AlternatingCharacters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int i = 0; i < queries; i++) {
            String word = scanner.next();
            System.out.println(alternatingCharacters(word));
        }
    }

    private static int alternatingCharacters(String word) {

        char[] charArr = word.toCharArray();
        char currChar = charArr[0];
        int count = 0;

        for (int i = 1; i < charArr.length; i++) {
            if (charArr[i] == currChar) {
                count++;
            } else {
                currChar = charArr[i];
            }
        }

        return count;
    }
}
