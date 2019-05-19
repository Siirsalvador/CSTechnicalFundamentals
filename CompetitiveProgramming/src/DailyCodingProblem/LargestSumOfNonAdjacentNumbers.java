package DailyCodingProblem;

public class LargestSumOfNonAdjacentNumbers {

    static int max;

    /**
     * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
     * <p>
     * For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
     */

    public static int findLargestSumOfAdjacentNumbers(int[] arrayInput) {

        int[] arrayOfSumsAtEachIndex = new int[arrayInput.length * 2];

        int firstIndex = 0;
        int secondIndex = 1;

        for (int i = 0; i < arrayInput.length; i++) {
            int sumForFirstIndex = arrayInput[i];
            int sumForSecondIndex = arrayInput[i];

            int firstIndexCondition = i + 2;
            int secondIndexCondition = i + 3;

            while (firstIndexCondition < arrayInput.length) {
                sumForFirstIndex += arrayInput[firstIndexCondition];
                firstIndexCondition += 2;
            }

            while (secondIndexCondition < arrayInput.length) {
                sumForSecondIndex += arrayInput[secondIndexCondition];
                secondIndexCondition += 3;
            }

            arrayOfSumsAtEachIndex[firstIndex] = sumForFirstIndex;
            findMaxValue(sumForFirstIndex);
            arrayOfSumsAtEachIndex[secondIndex] = sumForSecondIndex;
            findMaxValue(sumForSecondIndex);

            firstIndex += 2;
            secondIndex += 2;
        }

        return max;
    }

    public static void findMaxValue(int number) {
        if (number > max) {
            max = number;
        }
    }

    public static void main(String[] args) {
        int[] firstArrayInput = {2, 4, 6, 2, 5};
        int[] secondArrayInput = {5, 1, 1, 5};
        int[] thirdArrayInput = {5, 5, 10, 100, 10, 5};
        int[] fourthArrayInput = {1, 20, 3};

        System.out.println(findLargestSumOfAdjacentNumbers(firstArrayInput));
        max = 0;
        System.out.println(findLargestSumOfAdjacentNumbers(secondArrayInput));
        max = 0;
        System.out.println(findLargestSumOfAdjacentNumbers(thirdArrayInput));
        max = 0;
        System.out.println(findLargestSumOfAdjacentNumbers(fourthArrayInput));
        max = 0;
    }
}

//0 - 0, 1
//1 - 2, 3
//2 - 4, 5
//3 - 6, 7
//4 - 8, 9