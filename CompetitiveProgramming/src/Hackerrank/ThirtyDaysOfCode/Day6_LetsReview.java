package Hackerrank.ThirtyDaysOfCode;

import java.util.Scanner;

public class Day6_LetsReview {

    public static void printModifiedWord(String word) {
        String charAtEvenIndex = "";
        String charAtOddIndex = "";

        for (int i = 0; i < word.length(); i++) {
            if (i % 2 == 0) {
                charAtEvenIndex += word.charAt(i);
            } else {
                charAtOddIndex += word.charAt(i);
            }
        }

        System.out.println(charAtEvenIndex + " " + charAtOddIndex);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfTestCases = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < numberOfTestCases; i++) {
            String word = scan.nextLine();
            printModifiedWord(word);

        }

    }
}
