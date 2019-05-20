package Random.HENNGEChallenge003;

import java.util.Scanner;

public class SumOfSquares {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //N>=1 && N<=100
        //No blank line between test cases
        int numberOfTestCases = scanner.nextInt();

        while (numberOfTestCases > 0) {
            int numberOfIntegers = scanner.nextInt();

            int[] arrOfIntegers = new int[numberOfIntegers];
            int i = 0;
            while (i != numberOfIntegers - 1) {
                if (scanner.nextInt() > 0) {
                    arrOfIntegers[i] = scanner.nextInt();
                    i++;
                }

                SumOfSquares sumOfSquares = new SumOfSquares();
                int sum = sumOfSquares.calculateSquareSum(arrOfIntegers);
                System.out.println(sum);

                numberOfTestCases--;
            }
        }
    }

    public int calculateSquareSum(int[] arr) {
        int sum = 0;
        int count = arr.length - 1;
        while (count != 0) {
            sum = arr[count] * arr[count];
            count--;
        }
        return sum;
    }
}
