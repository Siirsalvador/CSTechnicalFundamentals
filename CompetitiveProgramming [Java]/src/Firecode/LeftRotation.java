package Firecode;

import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-04
 */
public class LeftRotation {

    private static int[] rotateLeft(int[] arr, int k) {
        int size = arr.length;
        k = k % size;

        int leftEnd = size - k - 1;
        int rightStart = size - k;

        reverse(arr, 0, size - 1);
        reverse(arr, 0, leftEnd);
        reverse(arr, rightStart, size - 1);

        return arr;
    }

    private static int[] rotateRight(int[] arr, int k) {
        int size = arr.length;
        k = k % size;

        int leftEnd = k - 1;
        int rightStart = k;

        reverse(arr, 0, size - 1);
        reverse(arr, 0, leftEnd);
        reverse(arr, rightStart, size - 1);

        return arr;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(rotateLeft(arr, 2)));
        arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(rotateRight(arr, 2)));
    }
}
