package Firecode;

import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-28
 */
public class SelectionSortVsMergeSort {

    public static void main(String[] args) {

        long startTime = System.nanoTime();

        int[] res = {1, 5, 6, 7, 3, 2};
        selectionSort(res);
        System.out.println(Arrays.toString(res));

        long endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) + " ns");

        startTime = System.nanoTime();
        int[] res2 = {1, 5, 6, 7, 3, 2};
        mergeSort(res2, 0, res2.length - 1);
        System.out.println(Arrays.toString(res2));

        endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) + " ns");
    }

    public static void selectionSort(int[] list) {

        for (int i = 0; i < list.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = list[min];
                list[min] = list[i];
                list[i] = temp;
            }
        }
    }

    public static void mergeSort(int[] list, int start, int end) {
        if (start == end) return;

        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(list, start, mid);
            mergeSort(list, mid + 1, end);
            merge(list, start, mid, end);
        }
    }

    private static void merge(int[] list, int start, int mid, int end) {

        int firstIdx = start;
        int secIdx = mid + 1;

        int[] result = new int[list.length];
        int resIdx = start;

        while (firstIdx <= mid && secIdx <= end) {

            if (list[firstIdx] < list[secIdx]) {
                result[resIdx] = list[firstIdx];
                firstIdx++;
            } else {
                result[resIdx] = list[secIdx];
                secIdx++;
            }

            resIdx++;
        }

        while (firstIdx <= mid) {
            result[resIdx] = list[firstIdx];
            firstIdx++;
            resIdx++;
        }

        while (secIdx <= end) {
            result[resIdx] = list[secIdx];
            secIdx++;
            resIdx++;
        }

        while (start <= end) {
            list[start] = result[start];
            start++;
        }
    }
}
