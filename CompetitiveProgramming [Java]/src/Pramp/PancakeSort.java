package Pramp;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-02
 */
public class PancakeSort {

    static int[] pancakeSort(int[] arr) {
        // your code goes here
        int k = -1;
        int max = Integer.MIN_VALUE;
        int maxIdx = arr.length - 1;


        //[1, 3, 1]
        for (int a = 0; a < arr.length; a++) {

            //maxIdx = 2
            for (int i = 0; i <= maxIdx; i++) {
                if (arr[i] > max) {
                    max = arr[i]; //max = 3
                    k = i; // 1
                }
            }

            flip(arr, k);
            flip(arr, maxIdx);
            max = Integer.MIN_VALUE;
            maxIdx--;
        }

        return arr;
    }

    static void flip(int[] arr, int k) {

        int start = 0;
        int end = k;

        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

    }
}

/*
arr =
flip(arr, 3)

[1, 5, 4, 3, 2]
max = 5
indexMax = 4
[5, 1, 4, 3, 2]
[2, 3, 4, 1, 5]

n(n + n + n) = n(3n) = n^2

max = 4
indexMax = 3
[4, 3, 2, 1, 5]
[1, 2, 3, 4, 5]


[100, 1, 5, -10]

flip (arr, 4)
[3, 4, 5, 1, 2]
flip()...

[1, 2, 3, 4, 5]

*/

