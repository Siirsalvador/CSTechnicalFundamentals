package DataStructures.Sorting.MergeSort;

import java.util.Scanner;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-19
 */
public class MergeSrt {

    /* Our array has up to n = 100,000 elements. That means there may be O(n^2) swaps.
           n^2 is 10,000,000,000. A Java int has max value 2,147,483,647 so we use a long
           to avoid integer overflow */
    private static long swaps = 0;

    public static long countInversions(int[] array) {
        mergesort(array, new int[array.length], 0, array.length - 1);
        long swapsAcc = swaps;
        swaps = 0;
        return swapsAcc;
    }

    private static void mergesort(int[] array, int[] temp, int leftStart, int rightEnd) {
        if (leftStart < rightEnd) {
            int middle = (leftStart + rightEnd) / 2;
            mergesort(array, temp, leftStart, middle);
            mergesort(array, temp, middle + 1, rightEnd);
            mergeHalves(array, temp, leftStart, rightEnd);
        }
    }

    private static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {

        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;

        int size = (rightEnd - leftStart) + 1;

        int leftIdx = leftStart;
        int rightIdx = rightStart;

        int tempIdx = leftStart;

        while (leftIdx <= leftEnd && rightIdx <= rightEnd) {

            if (array[leftIdx] <= array[rightIdx]) {
                temp[tempIdx] = array[leftIdx];
                leftIdx++;
            } else {

                swaps += rightStart - leftIdx;

                temp[tempIdx] = array[rightIdx];
                rightIdx++;
            }

            tempIdx++;
        }

        //Only one will take effect
        System.arraycopy(array, leftIdx, temp, tempIdx, (leftEnd - leftIdx) + 1);
        System.arraycopy(array, rightIdx, temp, tempIdx, (rightEnd - rightIdx) + 1);

        System.arraycopy(temp, leftStart, array, leftStart, size);


    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int datasets = scanner.nextInt();

        for (int i = 0; i < datasets; i++) {
            int currArrSize = scanner.nextInt();
            int[] currArr = new int[currArrSize];
            for (int j = 0; j < currArrSize; j++) {
                currArr[j] = scanner.nextInt();
            }

            System.out.println(countInversions(currArr));
        }


        /*
        * Fails on input:
            2
            4
            1 5 3 7
            4
            7 5 3 1
        * Expected Output:
            1
            7
        * */
    }
}
