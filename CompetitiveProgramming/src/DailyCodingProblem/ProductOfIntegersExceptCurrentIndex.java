package DailyCodingProblem;

import java.util.Arrays;

/***
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 *
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 *
 * Follow-up: what if you can't use division?
 */
public class ProductOfIntegersExceptCurrentIndex {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};

        calculateNoninclusiveProduct(input);
    }

    public static void calculateNoninclusiveProduct(int[] input) {
        int multiplication = 0;
        int mulplicationTemp = 0;
        int[] updatedInput = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            if (multiplication == 0)
                multiplication = input[i];
            else
                multiplication = multiplication * input[i];
        }

        for (int i = 0; i < input.length; i++) {
            mulplicationTemp = multiplication;
            updatedInput[i] = mulplicationTemp / input[i];
        }

        System.out.println(Arrays.toString(updatedInput));
    }
}
