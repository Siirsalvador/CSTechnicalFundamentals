package Hackerrank.InterviewPrepKit;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MinSwaps {

    static int minimumSwaps(int[] arr) {

        Map<Integer, Integer> sortedNumberstoInitialIndex = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            sortedNumberstoInitialIndex.put(arr[i], i);
        }
        System.out.println(sortedNumberstoInitialIndex);
        System.out.println("\n");
        System.out.println(Arrays.toString(arr));
        System.out.println("\n");

        int swapCount = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != i + 1) {
                int originalIndexOfValueToBeInCurrentIndex = sortedNumberstoInitialIndex.get(i + 1);

                /**
                 * Update value's index position in Map, so that if it needs to be referenced in the future,
                 * the most recent index value is used
                 */
                sortedNumberstoInitialIndex.put(arr[i], originalIndexOfValueToBeInCurrentIndex);
                sortedNumberstoInitialIndex.put(i + 1, i);

                System.out.println(sortedNumberstoInitialIndex);
                System.out.println("\n");

                /**
                 * Swap:
                 * Set (wrong) value in current position to originalIndexOfValueToBeInCurrentIndex,
                 * Then set (right) value to current index
                 */
                swap(arr, i, originalIndexOfValueToBeInCurrentIndex);

                swapCount++;
            }
        }

        return swapCount;
    }

    static void swap(int[] arr, int actualIndex, int intialIndex) {
        int temp = arr[actualIndex];
        arr[actualIndex] = arr[intialIndex];
        arr[intialIndex] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 4, 3, 2};
        int[] b = {7, 1, 3, 2, 4, 5, 6};
        int[] c = {4, 3, 1, 2};
        int[] d = {1, 3, 5, 2, 4, 6, 7};

        System.out.println(minimumSwaps(a));
        System.out.println(minimumSwaps(b));
        System.out.println(minimumSwaps(c)); //Expected: 3
        System.out.println(minimumSwaps(d)); //Expected: 3
    }
}

