package Firecode;

import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-05
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] firstArr = new int[0];
        int[] secArr = {2, 4, 7, 12};

        System.out.println(Arrays.toString(merge(firstArr, secArr)));
    }

    public static int[] merge(int[] arrLeft, int[] arrRight) {
        int firstIdx = 0;
        int secIdx = 0;

        int[] result = new int[arrLeft.length + arrRight.length];
        int resIdx = 0;

        while (firstIdx < arrLeft.length && secIdx < arrRight.length) {
            if (arrLeft[firstIdx] < arrRight[secIdx]) {
                result[resIdx] = arrLeft[firstIdx];
                firstIdx++;
            } else {
                result[resIdx] = arrRight[secIdx];
                secIdx++;
            }

            resIdx++;
        }

        while (firstIdx < arrLeft.length) {
            result[resIdx] = arrLeft[firstIdx];
            firstIdx++;
            resIdx++;
        }

        while (secIdx < arrRight.length) {
            result[resIdx] = arrRight[secIdx];
            secIdx++;
            resIdx++;
        }

        return result;

    }

    public void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int middle = start + (end - start) / 2;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle + 1, end);
            merge(arr, start, middle, end);
        }
    }

    private void merge(int[] arr, int start, int middle, int end) {
        int firstIdx = start;
        int secIdx = middle + 1;
        int resIdx = 0;

        int[] result = new int[arr.length];

        while (firstIdx <= middle && secIdx <= end) {
            //put in small value, increase index
            if (arr[firstIdx] < arr[secIdx]) {
                result[resIdx] = arr[firstIdx];
                firstIdx++;
            } else {
                result[resIdx] = arr[secIdx];
                secIdx++;
            }

            resIdx++;
        }

        //if any side has elements left, add all to array
        if (firstIdx != middle) {
            System.arraycopy(arr, firstIdx, result, resIdx, middle - firstIdx + 1);
        }

        if (secIdx != end) {
            System.arraycopy(arr, secIdx, result, resIdx, end - secIdx + 1);
        }

        for (int i = start; i <= end; i++) {
            arr[i] = result[i];
        }

    }
}
