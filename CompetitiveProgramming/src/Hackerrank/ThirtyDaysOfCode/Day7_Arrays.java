package Hackerrank.ThirtyDaysOfCode;

import java.util.Scanner;

public class Day7_Arrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int sizeOfArray = scan.nextInt();
        scan.nextLine();

        int[] arrayOfNumbers = new int[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            arrayOfNumbers[i] = scan.nextInt();
        }

        for (int i = 0; i < arrayOfNumbers.length; i++) {
            if (i == arrayOfNumbers.length - 1) {
                System.out.println(arrayOfNumbers[sizeOfArray - (i + 1)]);
            } else {
                System.out.print(arrayOfNumbers[sizeOfArray - (i + 1)] + " ");
            }
        }

    }
}
