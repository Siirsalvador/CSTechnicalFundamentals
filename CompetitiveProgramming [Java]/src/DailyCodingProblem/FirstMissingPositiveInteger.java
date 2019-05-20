package DailyCodingProblem;

public class FirstMissingPositiveInteger {

    static int min = Integer.MAX_VALUE;
    static String allNumbers = "";

    static int valueNotPresent;

    public static void main(String[] args) {
        int[] firstArrayInput = {3, 4, -1, 1}; //Should return 2
        int[] secondArrayInput = {1, 2, 0}; //Should return 3
        int[] thirdArrayInput = {2, 3, -7, 6, 8, 1, -10, 15}; // Should return 4

        System.out.println(findFirstMissingPositiveInteger(firstArrayInput));
        System.out.println(findFirstMissingPositiveInteger(secondArrayInput));
        System.out.println(findFirstMissingPositiveInteger(thirdArrayInput));
    }

    private static int findFirstMissingPositiveInteger(int[] arrayInput) {
        /**
         * Store all the numbers in a String seperated by a period
         * Find minimum number and if its not 1, return one
         * Else check if the number ++ is in the string, if it is, check if the next increment is in the string, until the an increment isn't present
         * return that number
         */

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < arrayInput.length; i++) {
            if (stringBuilder.length() == 0) {
                stringBuilder.append(arrayInput[i]);
            } else {
                stringBuilder.append(".");
                stringBuilder.append(arrayInput[i]);
            }
        }

        allNumbers = stringBuilder.toString();

        for (int i = 0; i < arrayInput.length; i++) {
            if (arrayInput[i] > 0) {
                if (arrayInput[i] < min) {
                    min = arrayInput[i];
                }
            }
        }

        if (min != 1) {
            return 1;
        } else {
            checkIfNextValueIsPresent(min + 1);
        }

        return valueNotPresent;
    }

    private static void checkIfNextValueIsPresent(int minimum) {
        if (allNumbers.contains(String.valueOf(minimum))) {
            minimum = minimum + 1;
            checkIfNextValueIsPresent(minimum);
        } else {
            valueNotPresent = minimum;
        }
    }

}
