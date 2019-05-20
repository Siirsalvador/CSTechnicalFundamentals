package DailyCodingProblem;

/**
 * There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time.
 * Given N, write a function that returns the number of unique ways you can climb the staircase.
 * The order of the steps matters.
 * <p>
 * For example, if N is 4, then there are 5 unique ways:
 * <p>
 * 1, 1, 1, 1
 * 2, 1, 1
 * 1, 2, 1
 * 1, 1, 2
 * 2, 2
 * <p>
 * What if, instead of being able to climb 1 or 2 steps at a time,
 * you could climb any number from a set of positive integers X?
 * For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 */
public class UniqueStaircaseClimbs {

    public static void findNumberOfUniqueWays(int n) {
        int result = calculateNumberOfUniqueWays(n);

        System.out.println(result);
    }

    private static int calculateNumberOfUniqueWays(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return calculateNumberOfUniqueWays(n - 1) + calculateNumberOfUniqueWays(n - 2);
    }

    private static int calculateNumberOfUniqueWaysWithSetOfSteps(int n, int[] arrayInput) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int result = 0;

        for (int i = 0; i < arrayInput.length; i++) {
            if (arrayInput[i] < n) {
                result += calculateNumberOfUniqueWaysWithSetOfSteps(n - arrayInput[i], arrayInput);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        findNumberOfUniqueWays(4);
        System.out.println(calculateNumberOfUniqueWaysWithSetOfSteps(4, new int[]{1, 3, 5}));
    }
}
