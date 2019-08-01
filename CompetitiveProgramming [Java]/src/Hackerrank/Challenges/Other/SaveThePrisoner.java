package Hackerrank.Challenges.Other;

import java.util.Scanner;

public class SaveThePrisoner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < numberOfTestCases; i++) {
            String[] arrayOfValues = scanner.nextLine().split(" ");

            int numberOfPrisoners = Integer.parseInt(arrayOfValues[0]);
            int numberOfSweets = Integer.parseInt(arrayOfValues[1]);
            int chairNumber = Integer.parseInt(arrayOfValues[2]);

            int result = saveThePrisoner(numberOfPrisoners, numberOfSweets, chairNumber);

            System.out.println(result);
        }
        scanner.close();

    }

    static int saveThePrisoner(int numberOfPrisoners, int numberOfSweets, int chairNumber) {
        int lastChair;
        if (numberOfSweets < numberOfPrisoners) {
            lastChair = numberOfSweets + chairNumber - 1;
            if (lastChair > numberOfPrisoners) {
                lastChair = lastChair - numberOfPrisoners;
            }

        } else {
            int numberOfPrisonersWhoHaveReceivedSweets = (numberOfPrisoners - chairNumber) + 1;
            int numberOfSweetsLeft = numberOfSweets - numberOfPrisonersWhoHaveReceivedSweets;
            lastChair = numberOfSweetsLeft % numberOfPrisoners;
            if (lastChair == 0) {
                lastChair = numberOfPrisoners;
            }
        }
        return Math.abs(lastChair);
    }
}
